package com.SmarDelivery.domain.usecases.entregador;

import com.SmarDelivery.domain.entities.Entregador;
import com.SmarDelivery.domain.gateway.EntregadorGateway;

public class BuscarEntregadorPorIdUsecaseImpl implements BuscarEntregadorPorIdUsecase {

    private final EntregadorGateway entregadorGateway;

    public BuscarEntregadorPorIdUsecaseImpl(EntregadorGateway entregadorGateway) {
        this.entregadorGateway = entregadorGateway;
    }

    @Override
    public Entregador execute(Long entregadorId) {
        return entregadorGateway.buscarEntregadorPorId(entregadorId).orElseThrow(() -> new RuntimeException("Entregador com id " + entregadorId + " não encontrado em sistema"));
    }
}
