package com.SmarDelivery.domain.entities;

public record ItemPedido(Long itemId,
                         int quantidade,
                         double precoUnitario,
                         Long pedidoId,
                         Long produtoId) {
}
