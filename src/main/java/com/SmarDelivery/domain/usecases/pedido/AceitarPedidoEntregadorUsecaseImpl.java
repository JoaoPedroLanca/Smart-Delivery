package com.SmarDelivery.domain.usecases.pedido;

import com.SmarDelivery.domain.entities.Pedido;
import com.SmarDelivery.domain.enums.StatusDoPedido;
import com.SmarDelivery.domain.gateway.PedidoGateway;

import java.util.Map;

public class AceitarPedidoEntregadorUsecaseImpl implements AceitarPedidoEntregadorUsecase {

    private final PedidoGateway pedidoGateway;

    public AceitarPedidoEntregadorUsecaseImpl(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    @Override
    public Pedido execute(Long pedidoId, Long entregadorId) {
        Pedido pedido = pedidoGateway.buscarPedidoPorId(pedidoId).orElseThrow(() -> new RuntimeException("Pedido com id " + pedidoId + " não encontrado em sistema"));

        if (pedido.statusPedido() != StatusDoPedido.EM_PRODUCAO) {
            throw new RuntimeException("Somente pedidos em produção podem ser aceitos para entrega");
        }

        Map<String, Object> atualizacoesEntrega = Map.of(
                "statusPedido", StatusDoPedido.EM_ENTREGA,
                "entregadorId", entregadorId);

        return pedidoGateway.atualizarPedido(pedidoId, atualizacoesEntrega);
    }
}
