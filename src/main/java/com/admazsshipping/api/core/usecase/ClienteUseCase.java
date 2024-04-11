package com.admazsshipping.api.core.usecase;

import com.admazsshipping.api.adapter.output.entity.ClienteEntity;
import com.admazsshipping.api.core.domain.Cliente;

public interface ClienteUseCase {

    ClienteEntity cadastrarCliente(Cliente cliente);
}
