package com.SmarDelivery.domain.usecases.cliente;

import com.SmarDelivery.domain.entities.Cliente;
import com.SmarDelivery.domain.gateway.ClienteGateway;

public class CriarClienteUseCaseImpl implements CriarClienteUseCase{

    private final ClienteGateway clienteGateway;

    public CriarClienteUseCaseImpl(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    @Override
    public Cliente execute(Cliente cliente) {
        return clienteGateway.criarCliente(cliente);
    }
}
