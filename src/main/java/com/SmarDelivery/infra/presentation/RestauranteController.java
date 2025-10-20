package com.SmarDelivery.infra.presentation;

import com.SmarDelivery.domain.entities.Restaurante;
import com.SmarDelivery.domain.usecases.restaurante.*;
import com.SmarDelivery.infra.dtos.requests.restaurante.PatchRestauranteRequestDto;
import com.SmarDelivery.infra.dtos.requests.restaurante.RestauranteRequestDto;
import com.SmarDelivery.infra.dtos.responses.restaurante.RestauranteResponseDto;
import com.SmarDelivery.infra.mappers.RestauranteMapper;
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
    private final AtualizarRestauranteUsecase atualizarRestauranteUsecase;
    private final DeletarRestaurantePorIdUsecase deletarRestaurantePorIdUsecase;
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

    @PatchMapping("/{id}")
    public ResponseEntity<RestauranteResponseDto> atualizarRestaurante(@PathVariable Long id, @RequestBody PatchRestauranteRequestDto patchDto) {
        Restaurante restauranteExiste = buscarRestaurantePorIdUsecase.execute(id);
        Restaurante restauranteAtualizado = restauranteMapper.patchToRestaurante(patchDto, restauranteExiste);
        restauranteAtualizado = atualizarRestauranteUsecase.execute(restauranteAtualizado);
        RestauranteResponseDto responseDto = restauranteMapper.toResponse(restauranteAtualizado);

        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarRestaurante(@PathVariable Long id) {
        deletarRestaurantePorIdUsecase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
