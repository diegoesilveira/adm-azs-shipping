package com.admazsshipping.api.core.usecase.impl;

import com.admazsshipping.api.adapter.output.entity.ClienteEntity;
import com.admazsshipping.api.adapter.output.entity.FreteEntity;
import com.admazsshipping.api.adapter.output.repository.ClienteRepository;
import com.admazsshipping.api.adapter.output.repository.EnderecoRepository;
import com.admazsshipping.api.core.domain.Cliente;
import com.admazsshipping.api.core.exception.ClienteAlreadyExistsException;
import com.admazsshipping.api.core.exception.FreteNotFoundException;
import com.admazsshipping.api.core.mapper.ClienteMapper;
import com.admazsshipping.api.core.usecase.ClienteUseCase;
import org.springframework.stereotype.Service;

@Service
public class ClienteUseCaseImpl implements ClienteUseCase {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    private final EnderecoRepository enderecoRepository;

    public ClienteUseCaseImpl(ClienteRepository clienteRepository, ClienteMapper clienteMapper, EnderecoRepository enderecoRepository) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public ClienteEntity cadastrarCliente(Cliente cliente) {

        clienteRepository.findById(cliente.getId()).
                orElseThrow(() -> new ClienteAlreadyExistsException("Cliente já existe. "));

        ClienteEntity clienteEntity = clienteMapper.toDomain(cliente);

        enderecoRepository.saveAll(clienteEntity.getEnderecoList());
        return clienteRepository.save(clienteEntity);
    }
}
