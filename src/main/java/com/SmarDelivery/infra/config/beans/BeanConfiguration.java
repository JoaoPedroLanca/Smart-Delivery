package com.SmarDelivery.infra.config.beans;

import com.SmarDelivery.domain.gateway.ClienteGateway;
import com.SmarDelivery.domain.usecases.cliente.BuscarClientePorIdUsecase;
import com.SmarDelivery.domain.usecases.cliente.BuscarClientePorIdUsecaseImpl;
import com.SmarDelivery.domain.usecases.cliente.BuscarTodosOsClientes;
import com.SmarDelivery.domain.usecases.cliente.BuscarTodosOsClientesImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class BeanConfiguration {

    @Bean
    public BuscarClientePorIdUsecase buscarClientePorIdUsecase(ClienteGateway clienteGateway) {
        return new BuscarClientePorIdUsecaseImpl(clienteGateway);
    }

    @Bean
    public BuscarTodosOsClientes buscarTodosOsClientes(ClienteGateway clienteGateway) {
        return new BuscarTodosOsClientesImpl(clienteGateway);
    }
}
