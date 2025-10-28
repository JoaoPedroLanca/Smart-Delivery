package com.SmarDelivery.infra.gateway;

import com.SmarDelivery.domain.entities.Cardapio;
import com.SmarDelivery.domain.gateway.CardapioGateway;
import com.SmarDelivery.infra.dtos.requests.cardapio.PatchCardapioRequestDto;
import com.SmarDelivery.infra.mappers.CardapioMapper;
import com.SmarDelivery.infra.persistence.entities.CardapioEntity;
import com.SmarDelivery.infra.persistence.repositories.CardapioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CardapioRepositoryGateway implements CardapioGateway {

    private final CardapioRepository cardapioRepository;
    private final CardapioMapper cardapioMapper;

    @Override
    public Cardapio criarCardapio(Cardapio cardapio) {
        CardapioEntity cardapioEntity = cardapioMapper.toEntity(cardapio);
        CardapioEntity novoCardapio = cardapioRepository.save(cardapioEntity);
        return cardapioMapper.toDomain(novoCardapio);
    }

    @Override
    public Optional<Cardapio> buscarCardapioPorId(Long cardapioId) {
        Optional<CardapioEntity> cardapio = cardapioRepository.findById(cardapioId);
        return cardapio.map(cardapioMapper::toDomain);
    }

    @Transactional
    @Override
    public Cardapio atualizarCardapio(Long cardapioId, Map<String, Object> atualizacao) {
        CardapioEntity cardapioEntity = cardapioRepository.findById(cardapioId)
                .orElseThrow(() -> new RuntimeException("Cardápio" + cardapioId + " não encontrado em sistema para atualização"));
        Cardapio cardapioDomain = cardapioMapper.toDomain(cardapioEntity);
        ObjectMapper objectMapper = new ObjectMapper();
        PatchCardapioRequestDto patchDto = objectMapper.convertValue(atualizacao, PatchCardapioRequestDto.class);
        Cardapio cardapioAtualizado = merge(patchDto, cardapioDomain);
        CardapioEntity cardapioAtualizadoEntity = cardapioMapper.toEntity(cardapioAtualizado);
        CardapioEntity novoCardapio = cardapioRepository.save(cardapioAtualizadoEntity);
        return cardapioMapper.toDomain(novoCardapio);
    }

    private Cardapio merge(PatchCardapioRequestDto patchDto, Cardapio cardapio) {
        return cardapioMapper.patchToCardapio(patchDto, cardapio);
    }

    @Override
    public void deletarProdutoPorId(Long cardapioId) {
        cardapioRepository.findById(cardapioId).orElseThrow(() -> new RuntimeException("Cardápio" + cardapioId + " não encontrado em sistema para deleção"));
        cardapioRepository.deleteById(cardapioId);
    }
}
