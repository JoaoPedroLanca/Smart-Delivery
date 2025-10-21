package com.SmarDelivery.infra.dtos.requests.cardapio;

public record PatchCardapioRequestDto(
        String nome,
        Double preco,
        Boolean disponivel
) {
}
