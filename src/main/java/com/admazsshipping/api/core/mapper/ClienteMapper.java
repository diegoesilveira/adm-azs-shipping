package com.admazsshipping.api.core.mapper;

import com.admazsshipping.api.adapter.output.entity.ClienteEntity;
import com.admazsshipping.api.adapter.output.entity.FreteEntity;
import com.admazsshipping.api.core.domain.Cliente;
import com.admazsshipping.api.core.domain.Frete;

public interface ClienteMapper {

    ClienteEntity toDomain(Cliente cliente);

    Cliente toDto(ClienteEntity cliente);
    ClienteEntity updateFromCliente(Cliente cliente, ClienteEntity entity);

}
