package com.SmarDelivery.infra.presentation;

import com.SmarDelivery.domain.entities.Restaurante;
import com.SmarDelivery.domain.usecases.restaurante.BuscarRestaurantePorIdUsecase;
import com.SmarDelivery.domain.usecases.restaurante.BuscarTodosRestaurantesUsecase;
import com.SmarDelivery.domain.usecases.restaurante.CriarRestauranteUsecase;
import com.SmarDelivery.infra.dtos.requests.restaurante.RestauranteRequestDto;
import com.SmarDelivery.infra.dtos.responses.restaurante.RestauranteResponseDto;
import com.SmarDelivery.infra.mappers.RestauranteMapper;
import com.SmarDelivery.infra.persistence.entities.RestauranteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

    private final CriarRestauranteUsecase criarRestauranteUsecase;
    private final BuscarTodosRestaurantesUsecase buscarTodosRestaurantesUsecase;
    private final BuscarRestaurantePorIdUsecase buscarRestaurantePorIdUsecase;
    private final RestauranteMapper restauranteMapper;

    @GetMapping
    public ResponseEntity<List<RestauranteResponseDto>> buscarTodosRestaurantes() {
        List<Restaurante> restaurantes = buscarTodosRestaurantesUsecase.execute();
        List<RestauranteResponseDto> restauranteResponse = restaurantes
                .stream()
                .map(restauranteMapper::toResponse)
                .toList();

        return ResponseEntity.ok(restauranteResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestauranteResponseDto> buscarRestaurantePorId(@PathVariable Long id) {
        Restaurante restaurante = buscarRestaurantePorIdUsecase.execute(id);
        RestauranteResponseDto response = restauranteMapper.toResponse(restaurante);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<RestauranteResponseDto> criarRestaurante(@RequestBody RestauranteRequestDto requestDto) {
        var restauranteDomain = restauranteMapper.toDomain(requestDto);
        var restauranteResponse = restauranteMapper.toResponse(criarRestauranteUsecase.execute(restauranteDomain));

        return ResponseEntity.status(HttpStatus.CREATED).body(restauranteResponse);
    }
}
