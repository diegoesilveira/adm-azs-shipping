package com.admazsshipping.api.core.usecase;

import com.admazsshipping.api.core.domain.Frete;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FreteUseCase {

    void cadastrarFrete(Frete frete);
    Page<Frete> buscarFretes(String termoBusca, Pageable pageable);
    void atualizarFrete(Long id, Frete frete);
    void removerFrete(Long id);
}
