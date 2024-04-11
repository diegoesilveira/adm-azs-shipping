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
public class FreteMapperImpl implements FreteMapper {
    @Override
    public FreteEntity toDomain(Frete frete) {
        return FreteEntity.builder()
                .dataCadastro(LocalDateTime.now())
                .descricao(frete.getDescricao())
                .propriedadesDinamicas(frete.getPropriedadesDinamicas())
                .cliente(getCliente(frete.getCliente()))
                .build();
    }

    private ClienteEntity getCliente(Cliente cliente) {
        return ClienteEntity.builder()
                .id(cliente.getId())
                .telefone(cliente.getTelefone())
                .nome(cliente.getNome())
                .email(cliente.getEmail())
                .enderecoList(getClienteEnderecoEntity(cliente.getEnderecoList()))
                .build();
    }

    private List<EnderecoEntity> getClienteEnderecoEntity(List<Endereco> enderecos) {
        return enderecos.stream()
                .map(endereco -> EnderecoEntity.builder()
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

    @Override
    public Frete toDto(FreteEntity frete) {
        return Frete.builder()
                .id(frete.getId())
                .descricao(frete.getDescricao())
                .dataCadastro(frete.getDataCadastro())
                .propriedadesDinamicas(frete.getPropriedadesDinamicas())
                .Cliente(getCliente(frete.getCliente()))
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
                        .id(enderecoEntity.getId())
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
    public FreteEntity updateFromFrete(Frete frete, FreteEntity entity) {
        return FreteEntity.builder()
                .id(entity.getId())
                .descricao(frete.getDescricao())
                .dataCadastro(LocalDateTime.now())
                .propriedadesDinamicas(frete.getPropriedadesDinamicas())
                .cliente(entity.getCliente())
                .build();
    }
}
