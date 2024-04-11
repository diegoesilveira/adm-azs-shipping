package com.admazsshipping.api.adapter.input.mapper;

import com.admazsshipping.api.adapter.input.dto.ClienteDto;
import com.admazsshipping.api.adapter.input.dto.EnderecoDto;
import com.admazsshipping.api.adapter.input.dto.FreteDto;
import com.admazsshipping.api.core.domain.Cliente;
import com.admazsshipping.api.core.domain.Endereco;
import com.admazsshipping.api.core.domain.Frete;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FreteMapperAdapterImpl implements FreteMapperAdapter {
    @Override
    public Frete toDomain(FreteDto freteDto) {
        return Frete.builder()
                .id(freteDto.getId())
                .Cliente(getCliente(freteDto.getCliente()))
                .dataCadastro(freteDto.getDataCadastro())
                .propriedadesDinamicas(freteDto.getPropriedadesDinamicas())
                .descricao(freteDto.getDescricao())
                .build();
    }

    private Cliente getCliente(ClienteDto clienteDto) {
        return Cliente.builder()
                .id(clienteDto.getId())
                .telefone(clienteDto.getTelefone())
                .nome(clienteDto.getNome())
                .email(clienteDto.getEmail())
                .enderecoList(getClienteDtoEnderecoDtoList(clienteDto.getEnderecoDtoList()))
                .build();
    }

    private List<Endereco> getClienteDtoEnderecoDtoList(List<EnderecoDto> enderecoDto) {
        return enderecoDto.stream()
                .map(endereco -> Endereco.builder()
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

    @Override
    public FreteDto toDto(Frete frete) {
        return FreteDto.builder()
                .id(frete.getId())
                .propriedadesDinamicas(frete.getPropriedadesDinamicas())
                .descricao(frete.getDescricao())
                .dataCadastro(frete.getDataCadastro())
                .cliente(getCliente(frete.getCliente()))
                .build();

    }

    private ClienteDto getCliente(Cliente cliente) {
        return ClienteDto.builder()
                .id(cliente.getId())
                .email(cliente.getEmail())
                .enderecoDtoList(getEnderecoList(cliente.getEnderecoList()))
                .nome(cliente.getNome())
                .telefone(cliente.getEmail())
                .build();
    }

    private static List<EnderecoDto> getEnderecoList(List<Endereco> enderecos) {
        return enderecos.stream()
                .map(endereco -> EnderecoDto.builder()
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
}
