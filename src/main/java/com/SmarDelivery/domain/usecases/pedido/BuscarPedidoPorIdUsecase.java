package com.SmarDelivery.domain.usecases.pedido;

import com.SmarDelivery.domain.entities.Pedido;

public interface BuscarPedidoPorIdUsecase {

    Pedido execute(Long pedidoId);
}

