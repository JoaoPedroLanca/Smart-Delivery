package com.SmarDelivery.domain.gateway;

import com.SmarDelivery.domain.entities.Entregador;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface EntregadorGateway {

    Entregador criarEntregador(Entregador entregador);

    List<Entregador> buscarTodosEntregadores();

    Optional<Entregador> buscarEntregadorPorId(Long entregadorId);

    Entregador atualizarEntregador(Long entregadorId, Map<String, Object> atualizacao);

    void deletarEntregadorPorId(Long entregadorId);
}
