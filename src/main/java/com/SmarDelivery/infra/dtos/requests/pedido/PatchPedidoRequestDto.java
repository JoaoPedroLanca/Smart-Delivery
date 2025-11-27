package com.SmarDelivery.infra.dtos.requests.pedido;

import com.SmarDelivery.domain.enums.StatusDoPedido;

public record PatchPedidoRequestDto(StatusDoPedido statusPedido) {
}

