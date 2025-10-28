package com.SmarDelivery.domain.usecases.entregador;

import com.SmarDelivery.domain.entities.Entregador;

import java.util.Map;

public interface AtualizarEntregadorUsecase {

    Entregador execute(Long entregadorId, Map<String, Object> atualizacao);
}
