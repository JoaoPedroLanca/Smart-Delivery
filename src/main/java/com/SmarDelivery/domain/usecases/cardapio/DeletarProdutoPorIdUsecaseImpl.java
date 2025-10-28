package com.SmarDelivery.domain.usecases.cardapio;

import com.SmarDelivery.domain.gateway.CardapioGateway;

public class DeletarProdutoPorIdUsecaseImpl implements DeletarProdutoPorIdUsecase {

    private final CardapioGateway cardapioGateway;

    public DeletarProdutoPorIdUsecaseImpl(CardapioGateway cardapioGateway) {
        this.cardapioGateway = cardapioGateway;
    }

    @Override
    public void execute(Long cardapioId) {
        cardapioGateway.buscarCardapioPorId(cardapioId).orElseThrow(() -> new RuntimeException("Cardápio não encontrado para deleção"));
        cardapioGateway.deletarProdutoPorId(cardapioId);
    }
}
