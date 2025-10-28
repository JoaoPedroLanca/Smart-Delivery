package com.SmarDelivery.domain.usecases.entregador;

import com.SmarDelivery.domain.entities.Entregador;
import com.SmarDelivery.domain.gateway.EntregadorGateway;

import java.util.Map;

public class AtualizarEntregadorUsecaseImpl implements AtualizarEntregadorUsecase {

    private final EntregadorGateway entregadorGateway;

    public AtualizarEntregadorUsecaseImpl(EntregadorGateway entregadorGateway) {
        this.entregadorGateway = entregadorGateway;
    }

    @Override
    public Entregador execute(Long entregadorId, Map<String, Object> atualizacao) {
        entregadorGateway.buscarEntregadorPorId(entregadorId).orElseThrow(() -> new RuntimeException("Entregador não encontrado em sistema para atualização"));
        return entregadorGateway.atualizarEntregador(entregadorId, atualizacao);
    }
}
