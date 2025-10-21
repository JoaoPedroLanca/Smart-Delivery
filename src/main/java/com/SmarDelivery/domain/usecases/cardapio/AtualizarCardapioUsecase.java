package com.SmarDelivery.domain.usecases.cardapio;

import com.SmarDelivery.domain.entities.Cardapio;

public interface AtualizarCardapioUsecase {

    Cardapio execute(Cardapio cardapioAtualizado);
}
