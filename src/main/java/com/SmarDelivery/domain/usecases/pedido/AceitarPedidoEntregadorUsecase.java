package com.SmarDelivery.domain.usecases.pedido;

import com.SmarDelivery.domain.entities.Pedido;

public interface AceitarPedidoEntregadorUsecase {

    Pedido execute(Long pedidoId, Long entregadorId);
}
