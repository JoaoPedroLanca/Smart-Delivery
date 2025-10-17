package com.SmarDelivery.domain.usecases.restaurante;

import com.SmarDelivery.domain.entities.Restaurante;

import java.util.List;

public interface BuscarTodosRestaurantesUsecase {

    List<Restaurante> execute();
}
