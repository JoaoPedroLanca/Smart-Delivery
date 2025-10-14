package com.SmarDelivery.domain.usecases.cliente;

import com.SmarDelivery.domain.gateway.ClienteGateway;

public class DeletarClientePorIdImpl implements DeletarClientePorId {

    private final ClienteGateway clienteGateway;

    public DeletarClientePorIdImpl(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    @Override
    public void execute(Long clienteId) {
        clienteGateway.buscarClientePorId(clienteId).orElseThrow(() -> new RuntimeException("Cliente não encontrado para deleção"));

        clienteGateway.deletarClientePorId(clienteId);
    }
}
