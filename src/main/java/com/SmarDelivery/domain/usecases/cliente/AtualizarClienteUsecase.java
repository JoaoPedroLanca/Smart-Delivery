package com.SmarDelivery.domain.usecases.cliente;

import com.SmarDelivery.domain.entities.Cliente;

import java.util.Map;

public interface AtualizarClienteUsecase {

    Cliente execute(Long clienteId, Map<String, Object> atualizacao);
}
