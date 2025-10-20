package com.SmarDelivery.infra.gateway;

import com.SmarDelivery.domain.entities.Cardapio;
import com.SmarDelivery.domain.gateway.CardapioGateway;
import com.SmarDelivery.infra.mappers.CardapioMapper;
import com.SmarDelivery.infra.persistence.entities.CardapioEntity;
import com.SmarDelivery.infra.persistence.entities.RestauranteEntity;
import com.SmarDelivery.infra.persistence.repositories.CardapioRepository;
import com.SmarDelivery.infra.persistence.repositories.RestauranteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CardapioRepositoryGateway implements CardapioGateway {

    private final CardapioRepository cardapioRepository;
    private final CardapioMapper cardapioMapper;
    private final RestauranteRepository restauranteRepository;

    @Override
    public Cardapio criarCardapio(Cardapio cardapio) {
        var cardapioEntity = cardapioMapper.toEntity(cardapio);
        var restauranteId = cardapio.restaurante_id();
        var restauranteEntity = restauranteRepository.findById(restauranteId)
                .orElseThrow(() -> new RuntimeException("Restaurante não encontrado"));
        cardapioEntity.setRestaurante(restauranteEntity);
        var novoCardapio = cardapioRepository.save(cardapioEntity);
        return cardapioMapper.toDomain(novoCardapio);
    }

    @Override
    public Optional<Cardapio> buscarCardapioPorId(Long cardapioId) {
        Optional<CardapioEntity> cardapio = cardapioRepository.findById(cardapioId);
        return cardapio.map(cardapioMapper::toDomain);
    }
}
