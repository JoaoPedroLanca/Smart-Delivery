package com.SmarDelivery.domain.usecases.cliente;

import com.SmarDelivery.domain.entities.Cliente;
import com.SmarDelivery.domain.gateway.ClienteGateway;

public class BuscarClientePorIdUsecaseImpl implements BuscarClientePorIdUsecase {

    private final ClienteGateway clienteGateway;

    public BuscarClientePorIdUsecaseImpl(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    @Override
    public Cliente execute(Long clienteId) {
        return clienteGateway.buscarClientePorId(clienteId).orElseThrow(() -> new RuntimeException("Id " + clienteId + " não encontrado em sistema"));
    }
}
