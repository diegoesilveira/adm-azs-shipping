package com.admazsshipping.api.adapter.input.mapper;

import com.admazsshipping.api.adapter.input.dto.FreteDto;
import com.admazsshipping.api.core.domain.Frete;

public interface FreteMapperAdapter {

    Frete toDomain(FreteDto freteDto);

    FreteDto toDto(Frete frete);
}
