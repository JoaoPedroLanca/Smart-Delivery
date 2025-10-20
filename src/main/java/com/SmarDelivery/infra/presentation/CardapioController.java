package com.SmarDelivery.infra.presentation;

import com.SmarDelivery.domain.entities.Cardapio;
import com.SmarDelivery.domain.usecases.cardapio.CriarCardapioUsecase;
import com.SmarDelivery.infra.dtos.requests.cardapio.CardapioRequestDto;
import com.SmarDelivery.infra.dtos.responses.cardapio.CardapioResponseDto;
import com.SmarDelivery.infra.mappers.CardapioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cardapio")
public class CardapioController {

    private final CriarCardapioUsecase criarCardapioUsecase;
    private final CardapioMapper cardapioMapper;

    @PostMapping
    public ResponseEntity<CardapioResponseDto> criarCardapio(@RequestBody CardapioRequestDto requestDto) {
        var cardapioDomain = cardapioMapper.toDomain(requestDto);
        var cardapioResponse = cardapioMapper.toResponse(criarCardapioUsecase.execute(cardapioDomain));
        return ResponseEntity.ok(cardapioResponse);
    }
}
