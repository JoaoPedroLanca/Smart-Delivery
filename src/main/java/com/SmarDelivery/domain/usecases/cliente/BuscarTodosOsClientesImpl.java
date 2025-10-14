package com.SmarDelivery.domain.usecases.cliente;

import com.SmarDelivery.domain.entities.Cliente;
import com.SmarDelivery.domain.gateway.ClienteGateway;

import java.util.List;

public class BuscarTodosOsClientesImpl implements BuscarTodosOsClientes {

    private final ClienteGateway clienteGateway;

    public BuscarTodosOsClientesImpl(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    @Override
    public List<Cliente> execute() {
        return clienteGateway.buscarTodosOsClientes();
    }
}
