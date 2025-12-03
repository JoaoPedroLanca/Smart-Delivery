package com.SmarDelivery.domain.usecases.pedido;

import com.SmarDelivery.domain.entities.Pedido;
import com.SmarDelivery.domain.enums.StatusDoPedido;
import com.SmarDelivery.domain.gateway.PedidoGateway;

import java.util.Map;

public class AceitarPedidoRestauranteUsecaseImpl implements AceitarPedidoRestauranteUsecase {

    private final PedidoGateway pedidoGateway;

    public AceitarPedidoRestauranteUsecaseImpl(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    @Override
    public Pedido execute(Long pedidoId) {
        Pedido pedido = pedidoGateway.buscarPedidoPorId(pedidoId).orElseThrow(() -> new RuntimeException("Pedido com id " + pedidoId + " não encontrado em sistema"));

        if (pedido.statusPedido() != StatusDoPedido.CRIADO) {
            throw new RuntimeException("Somente pedidos com status CRIADO podem ser aceitos pelo restaurante!");
        }

        Map<String, Object> atualizacaoDeStatus = Map.of("statusPedido", StatusDoPedido.EM_PRODUCAO);

        return pedidoGateway.atualizarPedido(pedidoId, atualizacaoDeStatus);
    }
}
