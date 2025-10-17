package com.SmarDelivery.infra.gateway;

import com.SmarDelivery.domain.entities.Restaurante;
import com.SmarDelivery.domain.gateway.RestauranteGateway;
import com.SmarDelivery.infra.mappers.RestauranteMapper;
import com.SmarDelivery.infra.persistence.entities.RestauranteEntity;
import com.SmarDelivery.infra.persistence.repositories.RestauranteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RestauranteRepositoryGateway implements RestauranteGateway {

    private final RestauranteRepository restauranteRepository;
    private final RestauranteMapper restauranteMapper;

    @Override
    public Restaurante criarRestaurante(Restaurante restaurante) {
        RestauranteEntity restauranteEntity = restauranteMapper.toEntity(restaurante);
        RestauranteEntity novoRestaurante = restauranteRepository.save(restauranteEntity);
        return restauranteMapper.toDomain(novoRestaurante);
    }
}
