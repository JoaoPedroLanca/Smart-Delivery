package com.SmarDelivery.domain.gateway;

import com.SmarDelivery.domain.entities.Restaurante;

import java.util.List;
import java.util.Optional;

public interface RestauranteGateway {

    List<Restaurante> buscarTodosRestaurantes();

    Optional<Restaurante> buscarRestaurantePorId(Long restauranteId);

    Restaurante criarRestaurante(Restaurante restaurante);

    Restaurante atualizarRestaurante(Restaurante restauranteAtualizado);

    void deletarRestaurantePorId(Long restauranteId);
}
