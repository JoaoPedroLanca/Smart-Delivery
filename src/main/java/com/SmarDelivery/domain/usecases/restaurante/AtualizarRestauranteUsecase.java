package com.SmarDelivery.domain.usecases.restaurante;

import com.SmarDelivery.domain.entities.Restaurante;

import java.util.Map;

public interface AtualizarRestauranteUsecase {

    Restaurante execute(Long restauranteId, Map<String, Object> atualizacao);
}
