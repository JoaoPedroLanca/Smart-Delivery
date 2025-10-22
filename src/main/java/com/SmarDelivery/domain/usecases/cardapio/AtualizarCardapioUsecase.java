package com.SmarDelivery.domain.usecases.cardapio;

import com.SmarDelivery.domain.entities.Cardapio;

import java.util.Map;

public interface AtualizarCardapioUsecase {

    Cardapio execute(Long cardapioId, Map<String, Object> atualizacao);
}
