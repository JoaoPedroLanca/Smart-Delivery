package com.SmarDelivery.domain.gateway;

import com.SmarDelivery.domain.entities.Cliente;

import java.util.Optional;

public interface ClienteGateway {

    Optional<Cliente> buscarClientePorId(Long clienteId);
}
