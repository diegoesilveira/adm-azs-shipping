package com.admazsshipping.api.adapter.input.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FreteDto {

    private Long id;
    private String descricao;
    private LocalDateTime dataCadastro;
    private Map<String, Object> propriedadesDinamicas;
    private ClienteDto cliente;

}
