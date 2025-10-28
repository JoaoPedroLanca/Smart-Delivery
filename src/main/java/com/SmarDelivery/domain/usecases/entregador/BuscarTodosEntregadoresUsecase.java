package com.SmarDelivery.domain.usecases.entregador;

import com.SmarDelivery.domain.entities.Entregador;

import java.util.List;

public interface BuscarTodosEntregadoresUsecase {

    List<Entregador> execute();
}
