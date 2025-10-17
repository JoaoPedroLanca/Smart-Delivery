package com.SmarDelivery.infra.config.beans;

import com.SmarDelivery.domain.gateway.ClienteGateway;
import com.SmarDelivery.domain.gateway.RestauranteGateway;
import com.SmarDelivery.domain.usecases.cliente.*;
import com.SmarDelivery.domain.usecases.restaurante.CriarRestauranteUsecase;
import com.SmarDelivery.domain.usecases.restaurante.CriarRestauranteUsecaseImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class BeanConfiguration {

    //Beans de Cliente

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

    @Bean
    public AtualizarClienteUsecase atualizarClienteUsecase(ClienteGateway clienteGateway) {
        return new AtualizarClienteUsecaseImpl(clienteGateway);
    }

    @Bean
    public DeletarClientePorId deletarClientePorId(ClienteGateway clienteGateway) {
        return new DeletarClientePorIdImpl(clienteGateway);
    }

    // Beans de Restaurante

    @Bean
    public CriarRestauranteUsecase criarRestaurante(RestauranteGateway restauranteGateway) {
        return new CriarRestauranteUsecaseImpl(restauranteGateway);
    }
}
