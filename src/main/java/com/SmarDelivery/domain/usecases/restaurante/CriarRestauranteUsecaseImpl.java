package com.SmarDelivery.domain.usecases.restaurante;

import com.SmarDelivery.domain.entities.Restaurante;
import com.SmarDelivery.domain.gateway.RestauranteGateway;

public class CriarRestauranteUsecaseImpl implements CriarRestauranteUsecase {

    private final RestauranteGateway restauranteGateway;

    public CriarRestauranteUsecaseImpl(RestauranteGateway restauranteGateway) {
        this.restauranteGateway = restauranteGateway;
    }

    @Override
    public Restaurante execute(Restaurante restaurante) {
        return restauranteGateway.criarRestaurante(restaurante);
    }
}
