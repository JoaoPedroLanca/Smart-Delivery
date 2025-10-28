package com.SmarDelivery.domain.usecases.entregador;

import com.SmarDelivery.domain.entities.Entregador;

public interface BuscarEntregadorPorIdUsecase {

    Entregador execute(Long entregadorId);
}
