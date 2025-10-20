package com.SmarDelivery.domain.usecases.cardapio;

import com.SmarDelivery.domain.entities.Cardapio;
import com.SmarDelivery.domain.gateway.CardapioGateway;

public class BuscarCardapioPorIdUsecaseImpl implements BuscarCardapioPorIdUsecase {

    private final CardapioGateway cardapioGateway;

    public BuscarCardapioPorIdUsecaseImpl(CardapioGateway cardapioGateway) {
        this.cardapioGateway = cardapioGateway;
    }

    @Override
    public Cardapio execute(Long cardapioId) {
        return cardapioGateway.buscarCardapioPorId(cardapioId).orElseThrow(() -> new RuntimeException("Cardápio não encontrado em sistema"));
    }
}
