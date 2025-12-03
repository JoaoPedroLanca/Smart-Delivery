package com.SmarDelivery.infra.dtos.responses.pedido;

public record ItemPedidoResponseDto(Long itemId,
                                    Long produtoId,
                                    double precoUnitario,
                                    int quantidade) {
}
