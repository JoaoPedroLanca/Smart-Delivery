package com.SmarDelivery.domain.usecases;

import com.SmarDelivery.domain.entities.Pedido;

public class CriarPedidoUsecaseImpl implements CriarPedidoUsecase{

    @Override
    public Pedido execute(Pedido pedido) {
        return pedido;
    }
}
