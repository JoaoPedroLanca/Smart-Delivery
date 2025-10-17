package com.SmarDelivery.domain.usecases.restaurante;

import com.SmarDelivery.domain.entities.Restaurante;
import com.SmarDelivery.domain.gateway.RestauranteGateway;

public class BuscarRestaurantePorIdUsecaseImpl implements BuscarRestaurantePorIdUsecase {

    private final RestauranteGateway restauranteGateway;

    public BuscarRestaurantePorIdUsecaseImpl(RestauranteGateway restauranteGateway) {
        this.restauranteGateway = restauranteGateway;
    }

    @Override
    public Restaurante execute(Long restauranteId) {
        return restauranteGateway.buscarRestaurantePorId(restauranteId).orElseThrow(() -> new RuntimeException("Restaurante com id " + restauranteId + " não encontrado em sistema"));
    }
}
