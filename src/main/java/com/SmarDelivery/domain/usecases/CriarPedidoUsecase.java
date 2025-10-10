package com.SmarDelivery.domain.usecases;

import com.SmarDelivery.domain.entities.Pedido;

public interface CriarPedidoUsecase {

    Pedido execute(Pedido pedido);
}
