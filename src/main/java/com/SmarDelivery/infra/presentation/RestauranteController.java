package com.SmarDelivery.infra.presentation;

import com.SmarDelivery.domain.usecases.restaurante.CriarRestauranteUsecase;
import com.SmarDelivery.infra.dtos.requests.restaurante.RestauranteRequestDto;
import com.SmarDelivery.infra.dtos.responses.restaurante.RestauranteResponseDto;
import com.SmarDelivery.infra.mappers.RestauranteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

    private final CriarRestauranteUsecase criarRestauranteUsecase;
    private final RestauranteMapper restauranteMapper;

    @PostMapping
    public ResponseEntity<RestauranteResponseDto> criarRestaurante(@RequestBody RestauranteRequestDto requestDto) {
        var restauranteDomain = restauranteMapper.toDomain(requestDto);
        var restauranteResponse = restauranteMapper.toResponse(criarRestauranteUsecase.execute(restauranteDomain));

        return ResponseEntity.status(HttpStatus.CREATED).body(restauranteResponse);
    }
}
