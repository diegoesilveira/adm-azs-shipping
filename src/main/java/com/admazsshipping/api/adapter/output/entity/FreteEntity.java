package com.admazsshipping.api.adapter.output.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "frete")
public class FreteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private LocalDateTime dataCadastro;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

    @ElementCollection
    @CollectionTable(name = "frete_propriedades", joinColumns = @JoinColumn(name = "frete_id"))
    @MapKeyColumn(name = "chave")
    @Column(name = "valor", columnDefinition = "TEXT")
    private Map<String, Object> propriedadesDinamicas = new HashMap<>();
}
