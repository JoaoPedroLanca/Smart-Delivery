package com.SmarDelivery.domain.usecases.pedido;

import com.SmarDelivery.domain.entities.Pedido;
import com.SmarDelivery.domain.gateway.PedidoGateway;

import java.util.List;

public class BuscarTodosPedidosUsecaseImpl implements BuscarTodosPedidosUsecase {

    private final PedidoGateway pedidoGateway;

    public BuscarTodosPedidosUsecaseImpl(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    @Override
    public List<Pedido> execute() {
        return pedidoGateway.buscarTodosPedidos();
    }
}

