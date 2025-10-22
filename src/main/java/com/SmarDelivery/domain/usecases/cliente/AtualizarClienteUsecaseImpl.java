package com.SmarDelivery.domain.usecases.cliente;

import com.SmarDelivery.domain.entities.Cliente;
import com.SmarDelivery.domain.gateway.ClienteGateway;

import java.util.Map;

public class AtualizarClienteUsecaseImpl implements AtualizarClienteUsecase {

    private final ClienteGateway clienteGateway;

    public AtualizarClienteUsecaseImpl(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    @Override
    public Cliente execute(Long clienteId, Map<String, Object> atualizacao) {
        clienteGateway.buscarClientePorId(clienteId).orElseThrow(() -> new RuntimeException("Cliente não encontrado para atualização"));
        return clienteGateway.atualizarCliente(clienteId, atualizacao);
    }
}
