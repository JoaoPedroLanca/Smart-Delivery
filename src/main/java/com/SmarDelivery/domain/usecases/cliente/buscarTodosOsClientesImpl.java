package com.SmarDelivery.domain.usecases.cliente;

import com.SmarDelivery.domain.entities.Cliente;
import com.SmarDelivery.domain.gateway.ClienteGateway;

import java.util.List;

public class buscarTodosOsClientesImpl implements buscarTodosOsClientes {

    private final ClienteGateway clienteGateway;

    public buscarTodosOsClientesImpl(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    @Override
    public List<Cliente> execute() {
        return clienteGateway.buscarTodosOsClientes();
    }
}
