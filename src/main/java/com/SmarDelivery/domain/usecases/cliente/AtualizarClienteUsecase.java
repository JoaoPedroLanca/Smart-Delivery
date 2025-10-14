package com.SmarDelivery.domain.usecases.cliente;

import com.SmarDelivery.domain.entities.Cliente;

public interface AtualizarClienteUsecase {

    Cliente execute(Cliente clienteAtualizado);
}
