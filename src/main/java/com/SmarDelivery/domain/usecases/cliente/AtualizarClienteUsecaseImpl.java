package com.SmarDelivery.domain.usecases.cliente;

import com.SmarDelivery.domain.entities.Cliente;
import com.SmarDelivery.domain.gateway.ClienteGateway;

public class AtualizarClienteUsecaseImpl implements AtualizarClienteUsecase {

    private final ClienteGateway clienteGateway;

    public AtualizarClienteUsecaseImpl(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    @Override
    public Cliente execute(Cliente clienteAtualizado) {
        clienteGateway.buscarClientePorId(clienteAtualizado.clienteId()).orElseThrow(() -> new RuntimeException("Cliente não encontrado para atualização"));
        return clienteGateway.atualizarCliente(clienteAtualizado);
    }
}
