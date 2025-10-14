package com.SmarDelivery.domain.gateway;

import com.SmarDelivery.domain.entities.Cliente;

import java.util.Optional;

public interface ClienteGateway {

    Cliente criarCliente(Cliente cliente);

    Optional<Cliente> buscarClientePorId(Long clienteId);
}
