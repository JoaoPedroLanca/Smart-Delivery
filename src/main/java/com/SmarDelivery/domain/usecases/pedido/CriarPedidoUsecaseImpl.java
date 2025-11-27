package com.SmarDelivery.domain.usecases.pedido;

import com.SmarDelivery.domain.entities.Cardapio;
import com.SmarDelivery.domain.entities.ItemPedido;
import com.SmarDelivery.domain.entities.Pedido;
import com.SmarDelivery.domain.entities.Restaurante;
import com.SmarDelivery.domain.enums.StatusDoPedido;
import com.SmarDelivery.domain.gateway.CardapioGateway;
import com.SmarDelivery.domain.gateway.PedidoGateway;
import com.SmarDelivery.domain.gateway.RestauranteGateway;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CriarPedidoUsecaseImpl implements CriarPedidoUsecase{

    private final PedidoGateway pedidoGateway;
    private final RestauranteGateway restauranteGateway;
    private final CardapioGateway cardapioGateway;

    public CriarPedidoUsecaseImpl(PedidoGateway pedidoGateway, 
                                  RestauranteGateway restauranteGateway,
                                  CardapioGateway cardapioGateway) {
        this.pedidoGateway = pedidoGateway;
        this.restauranteGateway = restauranteGateway;
        this.cardapioGateway = cardapioGateway;
    }

    @Override
    public Pedido execute(Pedido pedido) {
        // Valida se restaurante existe
        Restaurante restaurante = restauranteGateway.buscarRestaurantePorId(pedido.restauranteId())
                .orElseThrow(() -> new RuntimeException("Restaurante com ID " + pedido.restauranteId() + " não encontrado"));

        // Valida se restaurante está aberto
        if (!restaurante.aberto()) {
            throw new RuntimeException("Restaurante está fechado no momento");
        }

        // Valida e calcula total dos itens
        List<ItemPedido> itensValidados = new ArrayList<>();
        double totalDoPedido = 0.0;

        for (ItemPedido item : pedido.itensDoPedido()) {
            // Busca o produto no cardápio
            Cardapio produto = cardapioGateway.buscarCardapioPorId(item.produtoId())
                    .orElseThrow(() -> new RuntimeException("Produto com ID " + item.produtoId() + " não encontrado"));

            // Valida se produto está disponível
            if (!produto.disponivel()) {
                throw new RuntimeException("Produto " + produto.nome() + " não está disponível no momento");
            }

            // Calcula subtotal do item
            double subtotal = produto.preco() * item.quantidade();
            totalDoPedido += subtotal;

            // Cria item validado com preço unitário do produto
            ItemPedido itemValidado = new ItemPedido(
                    null, // itemId será gerado automaticamente
                    item.quantidade(),
                    produto.preco(),
                    null, // pedidoId será preenchido depois
                    item.produtoId()
            );
            itensValidados.add(itemValidado);
        }

        // Cria pedido com valores calculados e iniciais
        Pedido pedidoCompleto = new Pedido(
                null, // pedidoId será gerado automaticamente
                pedido.clienteId(),
                pedido.restauranteId(),
                null, // entregadorId será null inicialmente (até um entregador aceitar)
                itensValidados,
                totalDoPedido,
                StatusDoPedido.CRIADO,
                LocalDateTime.now(),
                pedido.enderecoCliente(),
                null, // distancia será calculada depois (Google Maps)
                pedido.formaDePagamento(),
                null // tempoEstimadoDeEntrega será calculado depois (Google Maps)
        );

        return pedidoGateway.criarPedido(pedidoCompleto);
    }
}
