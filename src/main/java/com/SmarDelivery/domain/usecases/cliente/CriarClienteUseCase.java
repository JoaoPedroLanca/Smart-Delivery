package com.SmarDelivery.domain.usecases.cliente;

import com.SmarDelivery.domain.entities.Cliente;

public interface CriarClienteUseCase {

    Cliente execute(Cliente cliente);
}
