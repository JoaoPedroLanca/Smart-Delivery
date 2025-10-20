package com.SmarDelivery.domain.usecases.cardapio;

import com.SmarDelivery.domain.entities.Cardapio;
import com.SmarDelivery.domain.gateway.CardapioGateway;
import com.SmarDelivery.domain.gateway.RestauranteGateway;

public class CriarCardapioUsecaseImpl implements CriarCardapioUsecase {

    private final CardapioGateway cardapioGateway;
    private final RestauranteGateway restauranteGateway;

    public CriarCardapioUsecaseImpl(CardapioGateway cardapioGateway, RestauranteGateway restauranteGateway) {
        this.cardapioGateway = cardapioGateway;
        this.restauranteGateway = restauranteGateway;
    }

    @Override
    public Cardapio execute(Cardapio cardapio) {
        restauranteGateway.buscarRestaurantePorId(cardapio.restaurante_id())
                .orElseThrow(() -> new RuntimeException("Cardápio deve estar associado a um restaurante existente"));
        return cardapioGateway.criarCardapio(cardapio);
    }
}
