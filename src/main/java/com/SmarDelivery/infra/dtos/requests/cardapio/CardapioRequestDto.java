package com.SmarDelivery.infra.dtos.requests.cardapio;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CardapioRequestDto(
        @NotBlank(message = "Um nome deve ser atribuído ao produto ")
        String nome,
        @NotNull(message = "O produto deve conter um valor")
        @Positive(message = "O valor do produto deve ser maior que zero")
        double preco,
        @NotNull(message = "Deve ser especificado se o produto está disponível")
        boolean disponivel,
        @NotNull(message = "O cardápio deve ser atribuído a um restaurante")
        Long restauranteId) {
}
