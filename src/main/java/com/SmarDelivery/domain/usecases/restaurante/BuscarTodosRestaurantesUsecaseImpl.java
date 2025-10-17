package com.SmarDelivery.domain.usecases.restaurante;

import com.SmarDelivery.domain.entities.Restaurante;
import com.SmarDelivery.domain.gateway.RestauranteGateway;

import java.util.List;

public class BuscarTodosRestaurantesUsecaseImpl implements BuscarTodosRestaurantesUsecase {

    private final RestauranteGateway restauranteGateway;

    public BuscarTodosRestaurantesUsecaseImpl(RestauranteGateway restauranteGateway) {
        this.restauranteGateway = restauranteGateway;
    }

    @Override
    public List<Restaurante> execute() {
        return restauranteGateway.buscarTodosRestaurantes();
    }
}
