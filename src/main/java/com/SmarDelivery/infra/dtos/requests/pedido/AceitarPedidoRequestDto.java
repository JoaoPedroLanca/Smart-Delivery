package com.SmarDelivery.infra.dtos.requests.pedido;

import jakarta.validation.constraints.NotNull;

public record AceitarPedidoRequestDto(
        @NotNull(message = "O ID do entregador é obrigatório")
        Long entregadorId) {
}
