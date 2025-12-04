package com.SmarDelivery.domain.usecases.pedido;

import com.SmarDelivery.domain.entities.Pedido;
import com.SmarDelivery.domain.enums.StatusDoPedido;
import com.SmarDelivery.domain.gateway.PedidoGateway;

import java.util.Map;

public class CancelarPedidoUsecaseImpl implements CancelarPedidoUsecase {

    private final PedidoGateway pedidoGateway;

    public CancelarPedidoUsecaseImpl(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    @Override
    public Pedido execute(Long pedidoId, Long clienteId, Long restauranteId) {
        Pedido pedido = pedidoGateway.buscarPedidoPorId(pedidoId).orElseThrow(() -> new RuntimeException("Pedido " + pedidoId + " não encontrado em sistema para finalização de entrega"));

        if (pedido.statusPedido() != StatusDoPedido.CRIADO && pedido.statusPedido() != StatusDoPedido.EM_PRODUCAO) {
            throw new RuntimeException("Somente pedidos com status 'CRIADO' ou 'EM_PRODUCAO' podem ser cancelados");
        }

        if (!pedido.clienteId().equals(clienteId) && !pedido.restauranteId().equals(restauranteId)) {
            throw new RuntimeException("Apenas o cliente ou o restaurante associado ao pedido podem cancelá-lo");
        }

        Map<String, Object> atualizacoesCancelamento = Map.of(
                "statusPedido", StatusDoPedido.CANCELADO);
        return pedidoGateway.atualizarPedido(pedidoId, atualizacoesCancelamento);
    }
}
