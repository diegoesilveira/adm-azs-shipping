package com.admazsshipping.api.adapter.input.dto;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private List<EnderecoDto> enderecoDtoList;
}
