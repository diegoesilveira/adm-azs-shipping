package com.admazsshipping.api.adapter.input.dto;


import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDto {

    private Long id;
    private String rua;
    private Integer numero;
    private String complemento;
    private String cep;
    private String bairro;
    private String uf;
    private String cidade;
    private Boolean isAtivo;
}
