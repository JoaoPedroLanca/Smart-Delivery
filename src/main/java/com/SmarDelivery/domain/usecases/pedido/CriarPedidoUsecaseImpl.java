package com.SmarDelivery.domain.usecases.pedido;

import com.SmarDelivery.domain.entities.Pedido;
import com.SmarDelivery.domain.gateway.PedidoGateway;

public class CriarPedidoUsecaseImpl implements CriarPedidoUsecase{

    private final PedidoGateway pedidoGateway;

    public CriarPedidoUsecaseImpl(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    @Override
    public Pedido execute(Pedido pedido) {
        return pedidoGateway.criarPedido(pedido);
    }
}
