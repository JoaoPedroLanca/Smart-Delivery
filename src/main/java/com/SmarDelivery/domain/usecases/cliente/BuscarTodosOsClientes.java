package com.SmarDelivery.domain.usecases.cliente;

import com.SmarDelivery.domain.entities.Cliente;

import java.util.List;

public interface BuscarTodosOsClientes {

    List<Cliente> execute();
}
