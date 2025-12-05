package com.SmarDelivery.domain.gateway;

import com.SmarDelivery.domain.entities.Pedido;

public interface NotificationGateway {

    void notificarPedidoCriado(Pedido pedido);
}