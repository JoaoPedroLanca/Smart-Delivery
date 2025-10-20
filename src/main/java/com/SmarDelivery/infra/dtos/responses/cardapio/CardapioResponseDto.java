package com.SmarDelivery.infra.dtos.responses.cardapio;

public record CardapioResponseDto(
        Long produtoId,
        String nome,
        double preco,
        boolean disponivel,
        Long restauranteId) {
}
