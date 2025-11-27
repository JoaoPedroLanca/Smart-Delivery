package com.SmarDelivery.infra.config.beans;

import com.SmarDelivery.domain.gateway.CardapioGateway;
import com.SmarDelivery.domain.gateway.ClienteGateway;
import com.SmarDelivery.domain.gateway.EntregadorGateway;
import com.SmarDelivery.domain.gateway.RestauranteGateway;
import com.SmarDelivery.domain.usecases.cardapio.*;
import com.SmarDelivery.domain.usecases.cliente.*;
import com.SmarDelivery.domain.usecases.entregador.*;
import com.SmarDelivery.domain.usecases.restaurante.*;
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

    @Bean
    public BuscarTodosRestaurantesUsecase buscarTodosRestaurantesUsecase(RestauranteGateway restauranteGateway) {
        return new BuscarTodosRestaurantesUsecaseImpl(restauranteGateway);
    }

    @Bean
    public BuscarRestaurantePorIdUsecase buscarRestaurantePorIdUsecase(RestauranteGateway restauranteGateway) {
        return new BuscarRestaurantePorIdUsecaseImpl(restauranteGateway);
    }

    @Bean
    public AtualizarRestauranteUsecase atualizarRestauranteUsecase(RestauranteGateway restauranteGateway) {
        return new AtualizarRestauranteUsecaseImpl(restauranteGateway);
    }

    @Bean
    public DeletarRestaurantePorIdUsecase deletarRestaurantePorIdUsecase(RestauranteGateway restauranteGateway) {
        return new DeletarRestaurantePorIdUsecaseImpl(restauranteGateway);
    }

    // Beans de Cardapio

    @Bean
    BuscarCardapioPorIdUsecase buscarCardapioPorIdUsecase(CardapioGateway cardapioGateway) {
        return new BuscarCardapioPorIdUsecaseImpl(cardapioGateway);
    }

    @Bean
    public CriarCardapioUsecase criarCardapioUsecase(CardapioGateway cardapioGateway, RestauranteGateway restauranteGateway) {
        return new CriarCardapioUsecaseImpl(cardapioGateway, restauranteGateway);
    }

    @Bean public AtualizarCardapioUsecase atualizarCardapioUsecase(CardapioGateway cardapioGateway) {
        return new AtualizarCardapioUsecaseImpl(cardapioGateway);
    }

    @Bean
    public DeletarProdutoPorIdUsecase deletarCardapioPorIdUsecase(CardapioGateway cardapioGateway) {
        return new DeletarProdutoPorIdUsecaseImpl(cardapioGateway);
    }

    // Beans de Entregador

    @Bean
    public CriarEntregadorUsecase criarEntregadorUsecase(EntregadorGateway entregadorGateway) {
        return new CriarEntregadorUsecaseImpl(entregadorGateway);
    }

    @Bean
    BuscarTodosEntregadoresUsecase buscarTodosEntregadoresUsecase(EntregadorGateway entregadorGateway) {
        return new BuscarTodosEntregadoresUsecaseImpl(entregadorGateway);
    }

    @Bean
    BuscarEntregadorPorIdUsecase buscarEntregadorPorIdUsecase(EntregadorGateway entregadorGateway) {
        return new BuscarEntregadorPorIdUsecaseImpl(entregadorGateway);
    }

    @Bean
    AtualizarEntregadorUsecase atualizarEntregadorUsecase(EntregadorGateway entregadorGateway) {
        return new AtualizarEntregadorUsecaseImpl(entregadorGateway);
    }

    @Bean
    DeletarEntregadorPorIdUsecase deletarEntregadorPorIdUsecase(EntregadorGateway entregadorGateway) {
        return new DeletarEntregadorPorIdUsecaseImpl(entregadorGateway);
    }
}
