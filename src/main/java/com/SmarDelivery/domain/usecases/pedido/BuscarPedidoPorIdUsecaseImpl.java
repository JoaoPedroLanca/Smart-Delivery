package com.SmarDelivery.domain.usecases.pedido;

import com.SmarDelivery.domain.entities.Pedido;
import com.SmarDelivery.domain.gateway.PedidoGateway;

public class BuscarPedidoPorIdUsecaseImpl implements BuscarPedidoPorIdUsecase {

    private final PedidoGateway pedidoGateway;

    public BuscarPedidoPorIdUsecaseImpl(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    @Override
    public Pedido execute(Long pedidoId) {
        return pedidoGateway.buscarPedidoPorId(pedidoId).orElseThrow(() -> new RuntimeException("Id " + pedidoId + " não encontrado em sistema"));
    }
}

