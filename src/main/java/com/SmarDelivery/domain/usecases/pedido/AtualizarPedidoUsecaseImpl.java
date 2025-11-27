package com.SmarDelivery.domain.usecases.pedido;

import com.SmarDelivery.domain.entities.Pedido;
import com.SmarDelivery.domain.enums.StatusDoPedido;
import com.SmarDelivery.domain.gateway.PedidoGateway;

import java.util.Map;

public class AtualizarPedidoUsecaseImpl implements AtualizarPedidoUsecase {

    private final PedidoGateway pedidoGateway;

    public AtualizarPedidoUsecaseImpl(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    @Override
    public Pedido execute(Long pedidoId, Map<String, Object> atualizacao) {
        pedidoGateway.buscarPedidoPorId(pedidoId).orElseThrow(() -> new RuntimeException("Pedido " + pedidoId + " não encontrado em sistema para atualização"));
        return pedidoGateway.atualizarPedido(pedidoId, atualizacao);
    }
}

