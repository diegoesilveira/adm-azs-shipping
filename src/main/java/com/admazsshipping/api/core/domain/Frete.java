package com.admazsshipping.api.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Frete {

    private Long id;
    private String descricao;
    private LocalDateTime dataCadastro;
    private Cliente Cliente;
    private Map<String, Object> propriedadesDinamicas = new HashMap<>();
}
