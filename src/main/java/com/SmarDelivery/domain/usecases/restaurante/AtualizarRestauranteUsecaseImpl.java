package com.SmarDelivery.domain.usecases.restaurante;

import com.SmarDelivery.domain.entities.Restaurante;
import com.SmarDelivery.domain.gateway.RestauranteGateway;

public class AtualizarRestauranteUsecaseImpl implements AtualizarRestauranteUsecase {

    private final RestauranteGateway restauranteGateway;

    public AtualizarRestauranteUsecaseImpl(RestauranteGateway restauranteGateway) {
        this.restauranteGateway = restauranteGateway;
    }

    @Override
    public Restaurante execute(Restaurante restauranteAtualizado) {
        restauranteGateway.buscarRestaurantePorId(restauranteAtualizado.restauranteId()).orElseThrow(() -> new RuntimeException("Restaurante não encontrado em sistema"));
        return restauranteGateway.atualizarRestaurante(restauranteAtualizado);
    }
}
