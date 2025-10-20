package com.SmarDelivery.domain.usecases.cardapio;

import com.SmarDelivery.domain.entities.Cardapio;

public interface BuscarCardapioPorIdUsecase {

    Cardapio execute(Long cardapioId);
}
