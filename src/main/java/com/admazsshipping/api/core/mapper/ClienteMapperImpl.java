package com.admazsshipping.api.core.mapper;

import com.admazsshipping.api.adapter.output.entity.ClienteEntity;
import com.admazsshipping.api.adapter.output.entity.EnderecoEntity;
import com.admazsshipping.api.adapter.output.entity.FreteEntity;
import com.admazsshipping.api.core.domain.Cliente;
import com.admazsshipping.api.core.domain.Endereco;
import com.admazsshipping.api.core.domain.Frete;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteMapperImpl implements ClienteMapper {
    @Override
    public ClienteEntity toDomain(Cliente cliente) {
        return ClienteEntity.builder()
                .id(cliente.getId())
                .nome(cliente.getNome())
                .email(cliente.getEmail())
                .telefone(cliente.getTelefone())
                .enderecoList(getClienteEnderecoEntity(cliente.getEnderecoList()))
                .build();
    }

    private List<EnderecoEntity> getClienteEnderecoEntity(List<Endereco> enderecos) {
        return enderecos.stream()
                .map(endereco -> EnderecoEntity.builder()
                        .id(endereco.getId())
                        .rua(endereco.getRua())
                        .uf(endereco.getUf())
                        .cep(endereco.getCep())
                        .isAtivo(endereco.getIsAtivo())
                        .numero(endereco.getNumero())
                        .bairro(endereco.getBairro())
                        .cidade(endereco.getCidade())
                        .complemento(endereco.getComplemento())
                        .build())
                .collect(Collectors.toList());
    }

    public ClienteEntity updateCliente(Cliente cliente) {
        return ClienteEntity.builder()
                .id(cliente.getId())
                .nome(cliente.getNome())
                .email(cliente.getEmail())
                .telefone(cliente.getTelefone())
                .enderecoList(getClienteEnderecoEntity(cliente.getEnderecoList()))
                .build();
    }

    @Override
    public Cliente toDto(ClienteEntity cliente) {
        return Cliente.builder()
                .email(cliente.getEmail())
                .enderecoList(getEnderecoList(cliente.getEnderecoList()))
                .nome(cliente.getNome())
                .telefone(cliente.getTelefone())
                .id(cliente.getId())
                .build();
    }

    private static Cliente getCliente(ClienteEntity cliente) {
        return Cliente.builder()
                .email(cliente.getEmail())
                .enderecoList(getEnderecoList(cliente.getEnderecoList()))
                .nome(cliente.getNome())
                .telefone(cliente.getTelefone())
                .id(cliente.getId())
                .build();
    }

    private static List<Endereco> getEnderecoList(List<EnderecoEntity> enderecoEntities) {
        return enderecoEntities.stream()
                .map(enderecoEntity -> Endereco.builder()
                        .rua(enderecoEntity.getRua())
                        .uf(enderecoEntity.getUf())
                        .cep(enderecoEntity.getCep())
                        .isAtivo(enderecoEntity.getIsAtivo())
                        .numero(enderecoEntity.getNumero())
                        .bairro(enderecoEntity.getBairro())
                        .cidade(enderecoEntity.getCidade())
                        .complemento(enderecoEntity.getComplemento())
                        .build())
                .collect(Collectors.toList());

    }

    @Override
    public ClienteEntity updateFromCliente(Cliente cliente, ClienteEntity entity) {
        return ClienteEntity.builder()
                .id(cliente.getId())
                .nome(cliente.getNome())
                .email(cliente.getEmail())
                .telefone(cliente.getTelefone())
                .enderecoList(getClienteEnderecoEntity(cliente.getEnderecoList()))
                .build();
    }
}
