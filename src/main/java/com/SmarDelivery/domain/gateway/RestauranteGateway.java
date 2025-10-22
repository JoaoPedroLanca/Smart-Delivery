package com.SmarDelivery.domain.gateway;

import com.SmarDelivery.domain.entities.Restaurante;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface RestauranteGateway {

    List<Restaurante> buscarTodosRestaurantes();

    Optional<Restaurante> buscarRestaurantePorId(Long restauranteId);

    Restaurante criarRestaurante(Restaurante restaurante);

    Restaurante atualizarRestaurante(Long restauranteId, Map<String, Object> atualizacao);

    void deletarRestaurantePorId(Long restauranteId);
}
