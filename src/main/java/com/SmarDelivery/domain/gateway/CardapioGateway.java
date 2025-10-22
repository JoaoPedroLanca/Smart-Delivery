package com.SmarDelivery.domain.gateway;

import com.SmarDelivery.domain.entities.Cardapio;

import java.util.Map;
import java.util.Optional;

public interface CardapioGateway {

    Cardapio criarCardapio(Cardapio cardapio);

    Optional<Cardapio> buscarCardapioPorId(Long cardapioId);

    Cardapio atualizarCardapio(Long cardapioId, Map<String, Object> atualizacao);
}
