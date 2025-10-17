package com.SmarDelivery.domain.usecases.restaurante;

import com.SmarDelivery.domain.entities.Restaurante;

public interface BuscarRestaurantePorIdUsecase {

    Restaurante execute(Long restauranteId);
}
