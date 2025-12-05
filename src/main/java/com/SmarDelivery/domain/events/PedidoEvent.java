package com.SmarDelivery.domain.events;

import com.SmarDelivery.domain.enums.StatusDoPedido;

import java.time.LocalDateTime;

public record PedidoEvent(
        Long pedidoId,
        Long clienteId,
        Long restauranteId,
        Long entregadorId,
        StatusDoPedido statusDoPedido,
        String tipoEvento,
        LocalDateTime timestampEvento
) {
}
