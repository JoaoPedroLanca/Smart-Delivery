package com.SmarDelivery.domain.usecases.pedido;

import com.SmarDelivery.domain.entities.Pedido;

public interface FinalizarEntregaUsecase {

    Pedido execute(Long pedidoId, Long entregadorId);
}
