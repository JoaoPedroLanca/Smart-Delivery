package com.SmarDelivery.infra.gateway;

import com.SmarDelivery.domain.entities.Restaurante;
import com.SmarDelivery.domain.gateway.RestauranteGateway;
import com.SmarDelivery.infra.mappers.RestauranteMapper;
import com.SmarDelivery.infra.persistence.entities.RestauranteEntity;
import com.SmarDelivery.infra.persistence.repositories.RestauranteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Restaurante> buscarTodosRestaurantes() {
        List<RestauranteEntity> restaurante = restauranteRepository.findAll();
        return restaurante
                .stream()
                .map(restauranteMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Restaurante> buscarRestaurantePorId(Long restauranteId) {
        Optional<RestauranteEntity> restaurante = restauranteRepository.findById(restauranteId);
        return restaurante.map(restauranteMapper::toDomain);
    }
}
