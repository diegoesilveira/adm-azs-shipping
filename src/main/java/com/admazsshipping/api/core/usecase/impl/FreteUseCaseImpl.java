package com.admazsshipping.api.core.usecase.impl;

import com.admazsshipping.api.adapter.output.entity.ClienteEntity;
import com.admazsshipping.api.adapter.output.entity.FreteEntity;
import com.admazsshipping.api.adapter.output.repository.FreteRepository;
import com.admazsshipping.api.core.domain.Frete;
import com.admazsshipping.api.core.exception.FreteAlreadyExistsException;
import com.admazsshipping.api.core.exception.FreteNotFoundException;
import com.admazsshipping.api.core.mapper.FreteMapper;
import com.admazsshipping.api.core.usecase.FreteUseCase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class FreteUseCaseImpl implements FreteUseCase {

    private final FreteRepository freteRepository;
    private final ClienteUseCaseImpl clienteUseCase;
    private final FreteMapper freteMapper;

    public FreteUseCaseImpl(FreteRepository freteRepository, ClienteUseCaseImpl clienteUseCase, FreteMapper freteMapper) {
        this.freteRepository = freteRepository;
        this.clienteUseCase = clienteUseCase;
        this.freteMapper = freteMapper;
    }

    @Override
    public void cadastrarFrete(Frete frete) {

        if (freteRepository.existsById(frete.getId())) {
            throw new FreteAlreadyExistsException("Já existe um frete com o ID fornecido");
        }
        ClienteEntity clienteEntity = clienteUseCase.cadastrarCliente(frete.getCliente());

        FreteEntity freteEntity = freteMapper.toDomain(frete);
        freteEntity.setCliente(clienteEntity);

        freteRepository.save(freteEntity);
    }

    @Override
    public Page<Frete> buscarFretes(String termoBusca, Pageable pageable) {
        Page<FreteEntity> fretePage = freteRepository.buscarPorTermo(termoBusca, pageable);
        return fretePage.map(freteMapper::toDto);
    }

    @Override
    public void atualizarFrete(Long id, Frete frete) {
        FreteEntity freteEntity = freteRepository.findById(id)
                .orElseThrow(() -> new FreteNotFoundException("Frete não encontrado com o ID: " + id));
        FreteEntity entity = freteMapper.updateFromFrete(frete, freteEntity);
        freteRepository.save(entity);

    }

    @Override
    public void removerFrete(Long id) {
        FreteEntity freteEntity = freteRepository.findById(id)
                .orElseThrow(() -> new FreteNotFoundException("Frete não encontrado com o ID: " + id));
        freteRepository.deleteById(id);
    }

}
