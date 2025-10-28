package com.SmarDelivery.domain.usecases.entregador;

import com.SmarDelivery.domain.entities.Entregador;
import com.SmarDelivery.domain.gateway.EntregadorGateway;

import java.util.List;

public class BuscarTodosEntregadoresUsecaseImpl implements BuscarTodosEntregadoresUsecase {

    private final EntregadorGateway entregadorGateway;

    public BuscarTodosEntregadoresUsecaseImpl(EntregadorGateway entregadorGateway) {
        this.entregadorGateway = entregadorGateway;
    }

    @Override
    public List<Entregador> execute() {
        return entregadorGateway.buscarTodosEntregadores();
    }
}
