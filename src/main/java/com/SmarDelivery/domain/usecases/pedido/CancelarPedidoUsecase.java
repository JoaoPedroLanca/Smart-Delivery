package com.SmarDelivery.domain.usecases.pedido;

import com.SmarDelivery.domain.entities.Pedido;

public interface CancelarPedidoUsecase {

    Pedido execute(Long pedidoId, Long clienteId, Long restauranteId);
}
