package com.SmarDelivery.domain.usecases.pedido;

import com.SmarDelivery.domain.entities.Pedido;
import com.SmarDelivery.domain.enums.StatusDoPedido;
import com.SmarDelivery.domain.gateway.PedidoGateway;

import java.util.Map;

public class FinalizarEntregaUsecaseImpl implements FinalizarEntregaUsecase {

    private final PedidoGateway pedidoGateway;

    public FinalizarEntregaUsecaseImpl(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    @Override
    public Pedido execute(Long pedidoId, Long entregadorId) {
        Pedido pedido = pedidoGateway.buscarPedidoPorId(pedidoId).orElseThrow(() -> new RuntimeException("Pedido " + pedidoId + " não encontrado em sistema para finalização de entrega"));

        if (pedido.statusPedido() != StatusDoPedido.EM_ENTREGA) {
            throw new RuntimeException("Somente pedidos com status 'EM_ENTREGA' podem ser finalizados");
        }

        if (pedido.entregadorId() == null ||  !pedido.entregadorId().equals(entregadorId)) {
            throw new RuntimeException("Entregador " + entregadorId + " não está associado ao pedido " + pedidoId + ", por tanto não pode finalizar a entrega");
        }

        Map<String, Object> atualizacaoPedido = Map.of(
                "statusPedido", StatusDoPedido.ENTREGUE);

        return pedidoGateway.atualizarPedido(pedidoId, atualizacaoPedido);
    }
}
