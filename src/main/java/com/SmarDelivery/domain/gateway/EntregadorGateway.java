package com.SmarDelivery.domain.gateway;

import com.SmarDelivery.domain.entities.Entregador;

import java.util.List;
import java.util.Optional;

public interface EntregadorGateway {

    Entregador criarEntregador(Entregador entregador);

    List<Entregador> buscarTodosEntregadores();

    Optional<Entregador> buscarEntregadorPorId(Long entregadorId);
}
