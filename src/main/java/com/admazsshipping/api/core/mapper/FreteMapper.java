package com.admazsshipping.api.core.mapper;

import com.admazsshipping.api.adapter.output.entity.FreteEntity;
import com.admazsshipping.api.core.domain.Frete;

public interface FreteMapper {

    FreteEntity toDomain(Frete frete);

    Frete toDto(FreteEntity frete);
    FreteEntity updateFromFrete(Frete frete, FreteEntity entity);

}
