package com.SmarDelivery.infra.dtos.requests.cardapio;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PatchCardapioRequestDto(
        String nome,
        double preco,
        boolean disponivel,
        Long restauranteId
) {
}
