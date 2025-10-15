package com.SmarDelivery.infra.config.beans;

import com.SmarDelivery.domain.gateway.ClienteGateway;
import com.SmarDelivery.domain.usecases.cliente.*;
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

    @Bean
    public CriarClienteUseCase criarClienteUseCase(ClienteGateway clienteGateway) {
        return new CriarClienteUseCaseImpl(clienteGateway);
    }
}
