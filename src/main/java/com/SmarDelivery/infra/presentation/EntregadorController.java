package com.SmarDelivery.infra.presentation;

import com.SmarDelivery.domain.entities.Entregador;
import com.SmarDelivery.domain.usecases.entregador.CriarEntregadorUsecase;
import com.SmarDelivery.infra.dtos.requests.entregador.EntregadorRequestDto;
import com.SmarDelivery.infra.dtos.responses.entregador.EntregadorResponseDto;
import com.SmarDelivery.infra.mappers.EntregadorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/entregador")
public class EntregadorController {

    private final CriarEntregadorUsecase criarEntregadorUsecase;
    private final EntregadorMapper entregadorMapper;

    @PostMapping
    public ResponseEntity<EntregadorResponseDto> criarEntregador(@RequestBody EntregadorRequestDto requestDto) {
        var entregadorDomain = entregadorMapper.toDomain(requestDto);
        var novoEntregador = criarEntregadorUsecase.execute(entregadorDomain);
        var responseDto = entregadorMapper.toResponse(novoEntregador);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }
}
