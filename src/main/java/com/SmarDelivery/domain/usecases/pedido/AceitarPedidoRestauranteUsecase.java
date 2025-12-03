package com.SmarDelivery.domain.usecases.pedido;

import com.SmarDelivery.domain.entities.Pedido;

public interface AceitarPedidoRestauranteUsecase {

    Pedido execute(Long pedidoId);
}
