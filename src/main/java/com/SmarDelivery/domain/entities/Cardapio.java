package com.SmarDelivery.domain.entities;

public record Cardapio(Long produtoId,
                       String nome,
                       double preco,
                       boolean disponivel,
                       Long restaurante_id) {
}
