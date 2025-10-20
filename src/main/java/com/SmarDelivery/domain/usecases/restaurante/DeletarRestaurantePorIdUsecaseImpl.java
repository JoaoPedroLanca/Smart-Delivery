package com.SmarDelivery.domain.usecases.restaurante;

import com.SmarDelivery.domain.gateway.RestauranteGateway;

public class DeletarRestaurantePorIdUsecaseImpl implements DeletarRestaurantePorIdUsecase {

    private final RestauranteGateway restauranteGateway;

    public DeletarRestaurantePorIdUsecaseImpl(RestauranteGateway restauranteGateway) {
        this.restauranteGateway = restauranteGateway;
    }

    @Override
    public void execute(Long restauranteId) {
        restauranteGateway.buscarRestaurantePorId(restauranteId).orElseThrow(() -> new RuntimeException("Restaurante não encontrado para deleção"));
        restauranteGateway.deletarRestaurantePorId(restauranteId);
    }
}
