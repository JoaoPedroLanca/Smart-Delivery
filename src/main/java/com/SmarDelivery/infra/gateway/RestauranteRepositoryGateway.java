package com.SmarDelivery.infra.gateway;

import com.SmarDelivery.domain.entities.Cliente;
import com.SmarDelivery.domain.entities.Restaurante;
import com.SmarDelivery.domain.gateway.RestauranteGateway;
import com.SmarDelivery.infra.dtos.requests.cliente.PatchClienteRequestDto;
import com.SmarDelivery.infra.dtos.requests.restaurante.PatchRestauranteRequestDto;
import com.SmarDelivery.infra.mappers.RestauranteMapper;
import com.SmarDelivery.infra.persistence.entities.ClienteEntity;
import com.SmarDelivery.infra.persistence.entities.RestauranteEntity;
import com.SmarDelivery.infra.persistence.repositories.RestauranteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
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

    @Override
    public Restaurante atualizarRestaurante(Long restauranteId, Map<String, Object> atualizacao) {
        RestauranteEntity restauranteEntity = restauranteRepository.findById(restauranteId)
                .orElseThrow(() -> new RuntimeException("Restaurante não encontrado em sistema"));
        Restaurante restauranteDomain = restauranteMapper.toDomain(restauranteEntity);
        ObjectMapper objectMapper = new ObjectMapper();
        PatchRestauranteRequestDto patchDto = objectMapper.convertValue(atualizacao, PatchRestauranteRequestDto.class);
        Restaurante restauranteAtualizado = merge(patchDto, restauranteDomain);
        RestauranteEntity restauranteAtualizadoEntity = restauranteMapper.toEntity(restauranteAtualizado);
        RestauranteEntity novoRestaurante = restauranteRepository.save(restauranteAtualizadoEntity);

        return restauranteMapper.toDomain(novoRestaurante);
    }

    private Restaurante merge(PatchRestauranteRequestDto patchDto, Restaurante restaurante) {
        return restauranteMapper.patchToRestaurante(patchDto, restaurante);
    }

    @Override
    public void deletarRestaurantePorId(Long restauranteId) {
        restauranteRepository.deleteById(restauranteId);
    }
}
