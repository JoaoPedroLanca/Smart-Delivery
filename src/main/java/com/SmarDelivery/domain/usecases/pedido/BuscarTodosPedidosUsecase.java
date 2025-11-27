package com.SmarDelivery.domain.usecases.pedido;

import com.SmarDelivery.domain.entities.Pedido;

import java.util.List;

public interface BuscarTodosPedidosUsecase {

    List<Pedido> execute();
}

