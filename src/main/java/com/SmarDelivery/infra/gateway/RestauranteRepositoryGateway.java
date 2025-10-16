package com.SmarDelivery.infra.gateway;

import com.SmarDelivery.domain.entities.Restaurante;
import com.SmarDelivery.domain.gateway.RestauranteGateway;
import com.SmarDelivery.infra.mappers.RestauranteMapper;
import com.SmarDelivery.infra.persistence.entities.RestauranteEntity;
import com.SmarDelivery.infra.persistence.repositories.RestauranteRepository;

public class RestauranteRepositoryGateway implements RestauranteGateway {

    private final RestauranteRepository restauranteRepository;
    private final RestauranteMapper restauranteMapper;

    public RestauranteRepositoryGateway(RestauranteRepository restauranteRepository, RestauranteMapper restauranteMapper) {
        this.restauranteRepository = restauranteRepository;
        this.restauranteMapper = restauranteMapper;
    }

    @Override
    public Restaurante criarRestaurante(Restaurante restaurante) {
        RestauranteEntity restauranteEntity = restauranteMapper.toEntity(restaurante);
        RestauranteEntity novoRestaurante = restauranteRepository.save(restauranteEntity);
        return restauranteMapper.toDomain(novoRestaurante);
    }
}
