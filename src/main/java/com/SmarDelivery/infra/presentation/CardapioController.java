package com.SmarDelivery.infra.presentation;

import com.SmarDelivery.domain.usecases.cardapio.AtualizarCardapioUsecase;
import com.SmarDelivery.domain.usecases.cardapio.CriarCardapioUsecase;
import com.SmarDelivery.domain.usecases.cardapio.DeletarProdutoPorIdUsecase;
import com.SmarDelivery.infra.dtos.requests.cardapio.CardapioRequestDto;
import com.SmarDelivery.infra.dtos.responses.cardapio.CardapioResponseDto;
import com.SmarDelivery.infra.mappers.CardapioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cardapio")
public class CardapioController {

    private final CriarCardapioUsecase criarCardapioUsecase;
    private final AtualizarCardapioUsecase atualizarCardapioUsecase;
    private final DeletarProdutoPorIdUsecase deletarProdutoPorIdUsecase;
    private final CardapioMapper cardapioMapper;

    @PostMapping
    public ResponseEntity<CardapioResponseDto> criarCardapio(@RequestBody CardapioRequestDto requestDto) {
        var cardapioDomain = cardapioMapper.toDomain(requestDto);
        var cardapioResponse = cardapioMapper.toResponse(criarCardapioUsecase.execute(cardapioDomain));
        return ResponseEntity.ok(cardapioResponse);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CardapioResponseDto> atualizarCardapio(@PathVariable Long id, @RequestBody Map<String, Object> atualizacao) {
        var cardapioAtualizado = cardapioMapper.toResponse(atualizarCardapioUsecase.execute(id, atualizacao));
        return ResponseEntity.ok(cardapioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProdutoPorId (@PathVariable Long id) {
        deletarProdutoPorIdUsecase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
