package com.SmarDelivery.domain.usecases.cardapio;

import com.SmarDelivery.domain.entities.Cardapio;
import com.SmarDelivery.domain.gateway.CardapioGateway;

public class AtualizarCardapioUsecaseImpl implements AtualizarCardapioUsecase {

    private final CardapioGateway cardapioGateway;

    public AtualizarCardapioUsecaseImpl(CardapioGateway cardapioGateway) {
        this.cardapioGateway = cardapioGateway;
    }

    @Override
    public Cardapio execute(Cardapio cardapioAtualizado) {
        cardapioGateway.buscarCardapioPorId(cardapioAtualizado.produtoId()).orElseThrow(() -> new RuntimeException("Cardápio não encontrado em sistema para atualização"));
        return cardapioGateway.atualizarCardapio(cardapioAtualizado);
    }
}
