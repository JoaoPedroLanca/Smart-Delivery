package com.SmarDelivery.domain.usecases.entregador;

import com.SmarDelivery.domain.gateway.EntregadorGateway;

public class DeletarEntregadorPorIdUsecaseImpl implements DeletarEntregadorPorIdUsecase {

    private final EntregadorGateway entregadorGateway;

    public DeletarEntregadorPorIdUsecaseImpl(EntregadorGateway entregadorGateway) {
        this.entregadorGateway = entregadorGateway;
    }

    @Override
    public void execute(Long entregadorId) {
        entregadorGateway.deletarEntregadorPorId(entregadorId);
    }
}
