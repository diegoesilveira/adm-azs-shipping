package com.admazsshipping.api.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

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
