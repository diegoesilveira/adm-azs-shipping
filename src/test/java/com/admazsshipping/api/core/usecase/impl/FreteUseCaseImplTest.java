package com.admazsshipping.api.core.usecase.impl;

import com.admazsshipping.api.adapter.output.entity.ClienteEntity;
import com.admazsshipping.api.adapter.output.entity.FreteEntity;
import com.admazsshipping.api.adapter.output.repository.FreteRepository;
import com.admazsshipping.api.core.domain.Frete;
import com.admazsshipping.api.core.exception.FreteAlreadyExistsException;
import com.admazsshipping.api.core.exception.FreteNotFoundException;
import com.admazsshipping.api.core.mapper.FreteMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FreteUseCaseImplTest {

    @Mock
    private FreteRepository freteRepository;

    @Mock
    private ClienteUseCaseImpl clienteUseCase;

    @Mock
    private FreteMapper freteMapper;

    @InjectMocks
    private FreteUseCaseImpl freteUseCase;

    @Test
    public void cadastrarFrete_DeveCadastrarComSucesso() {
        Frete frete = new Frete();
        ClienteEntity clienteEntity = new ClienteEntity();
        FreteEntity freteEntity = new FreteEntity();

        when(clienteUseCase.cadastrarCliente(any())).thenReturn(clienteEntity);
        when(freteMapper.toDomain(any())).thenReturn(freteEntity);

        freteUseCase.cadastrarFrete(frete);

        verify(freteRepository, times(1)).existsById(frete.getId());
        verify(freteRepository, times(1)).save(freteEntity);
    }

    @Test()
    public void cadastrarFrete_DeveLancarExcecaoQuandoFreteJaExistir() throws FreteAlreadyExistsException {
        Frete frete = new Frete();
        frete.setId(1L);

        when(freteRepository.existsById(frete.getId())).thenReturn(true);

        try {
            freteUseCase.cadastrarFrete(frete);
        } catch (FreteAlreadyExistsException io) {}

    }

    @Test()
    public void atualizarFrete_DeveLancarExcecaoQuandoFreteNaoForEncontrado() throws FreteNotFoundException{
        Long id = 1L;
        Frete frete = new Frete();
        frete.setId(id);

        when(freteRepository.findById(id)).thenReturn(Optional.empty());

        try {
            freteUseCase.atualizarFrete(id, frete);
        } catch (FreteNotFoundException ex) {}
    }

    @Test
    public void removerFrete_DeveRemoverFreteComSucesso() {
        Long id = 1L;
        FreteEntity freteEntity = new FreteEntity();

        when(freteRepository.findById(id)).thenReturn(Optional.of(freteEntity));

        freteUseCase.removerFrete(id);

        verify(freteRepository, times(1)).deleteById(id);
    }

    @Test()
    public void removerFrete_DeveLancarExcecaoQuandoFreteNaoForEncontrado() throws FreteNotFoundException {
        Long id = 1L;

        when(freteRepository.findById(id)).thenReturn(Optional.empty());

        try {
            freteUseCase.removerFrete(id);
        } catch (FreteNotFoundException ex) {}

    }


}