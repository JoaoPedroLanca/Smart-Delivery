package com.SmarDelivery.domain.usecases.pedido;

import com.SmarDelivery.domain.entities.Pedido;

public interface CriarPedidoUsecase {

    Pedido execute(Pedido pedido);
}
