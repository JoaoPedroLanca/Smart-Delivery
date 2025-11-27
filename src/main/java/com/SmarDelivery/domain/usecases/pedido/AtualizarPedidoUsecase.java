package com.SmarDelivery.domain.usecases.pedido;

import com.SmarDelivery.domain.entities.Pedido;

import java.util.Map;

public interface AtualizarPedidoUsecase {

    Pedido execute(Long pedidoId, Map<String, Object> atualizacao);
}

