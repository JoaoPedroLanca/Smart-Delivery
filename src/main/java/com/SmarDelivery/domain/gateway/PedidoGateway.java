package com.SmarDelivery.domain.gateway;

import com.SmarDelivery.domain.entities.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoGateway {

    Pedido criarPedido(Pedido pedido);

    Optional<Pedido> buscarPedidoPorId(Long pedidoId);

    List<Pedido> buscarTodosPedidos();
}
