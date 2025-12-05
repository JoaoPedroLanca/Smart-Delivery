package com.SmarDelivery.infra.dtos.events;

import com.SmarDelivery.domain.enums.StatusDoPedido;

import java.time.LocalDateTime;

public record PedidoEventDto(
        Long pedidoId,
        Long clienteId,
        Long restauranteId,
        Long entregadorId,
        StatusDoPedido statusDoPedido,
        String tipoEvento,
        LocalDateTime timestampEvento
) {
}
