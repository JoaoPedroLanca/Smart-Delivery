package com.SmarDelivery.domain.gateway;

import com.SmarDelivery.domain.entities.Entregador;

public interface EntregadorGateway {

    Entregador criarEntregador(Entregador entregador);

    Entregador buscarTodosEntregadores();

    Entregador buscarEntregadorPorId(Long entregadorId);
}
