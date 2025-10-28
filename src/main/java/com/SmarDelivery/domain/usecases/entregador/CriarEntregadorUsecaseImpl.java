package com.SmarDelivery.domain.usecases.entregador;

import com.SmarDelivery.domain.entities.Entregador;
import com.SmarDelivery.domain.gateway.EntregadorGateway;

public class CriarEntregadorUsecaseImpl implements CriarEntregadorUsecase {

    private final EntregadorGateway entregadorGateway;

    public CriarEntregadorUsecaseImpl(EntregadorGateway entregadorGateway) {
        this.entregadorGateway = entregadorGateway;
    }

    @Override
    public Entregador execute(Entregador entregador) {
        return entregadorGateway.criarEntregador(entregador);
    }
}
