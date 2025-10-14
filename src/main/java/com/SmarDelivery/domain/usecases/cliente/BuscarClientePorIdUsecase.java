package com.SmarDelivery.domain.usecases.cliente;

import com.SmarDelivery.domain.entities.Cliente;

public interface BuscarClientePorIdUsecase {

    Cliente execute(Long clienteId);
}
