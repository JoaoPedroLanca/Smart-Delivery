package com.SmarDelivery.domain.gateway;

import com.SmarDelivery.domain.entities.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteGateway {

    Cliente criarCliente(Cliente cliente);

    List<Cliente> buscarTodosOsClientes();

    Optional<Cliente> buscarClientePorId(Long clienteId);
}
