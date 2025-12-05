package com.SmarDelivery.domain.usecases.pedido;

import com.SmarDelivery.domain.entities.Cardapio;
import com.SmarDelivery.domain.entities.ItemPedido;
import com.SmarDelivery.domain.entities.Pedido;
import com.SmarDelivery.domain.entities.Restaurante;
import com.SmarDelivery.domain.enums.StatusDoPedido;
import com.SmarDelivery.domain.gateway.CardapioGateway;
import com.SmarDelivery.domain.gateway.NotificationGateway;
import com.SmarDelivery.domain.gateway.PedidoGateway;
import com.SmarDelivery.domain.gateway.RestauranteGateway;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CriarPedidoUsecaseImpl implements CriarPedidoUsecase{

    private final PedidoGateway pedidoGateway;
    private final RestauranteGateway restauranteGateway;
    private final CardapioGateway cardapioGateway;
    private final NotificationGateway notificationGateway;

    public CriarPedidoUsecaseImpl(PedidoGateway pedidoGateway, RestauranteGateway restauranteGateway, CardapioGateway cardapioGateway, NotificationGateway notificationGateway) {
        this.pedidoGateway = pedidoGateway;
        this.restauranteGateway = restauranteGateway;
        this.cardapioGateway = cardapioGateway;
        this.notificationGateway = notificationGateway;
    }

    @Override
    public Pedido execute(Pedido pedido) {

        Restaurante restaurante = restauranteGateway.buscarRestaurantePorId(pedido.restauranteId())
                .orElseThrow(() -> new RuntimeException("Restaurante com ID " + pedido.restauranteId() + " não encontrado"));

        if (!restaurante.aberto()) {
            throw new RuntimeException("Restaurante está fechado no momento");
        }

        List<ItemPedido> itensValidados = new ArrayList<>();
        double totalDoPedido = 0.0;

        for (ItemPedido item : pedido.itensDoPedido()) {

            Cardapio produto = cardapioGateway.buscarCardapioPorId(item.produtoId())
                    .orElseThrow(() -> new RuntimeException("Produto com ID " + item.produtoId() + " não encontrado"));

            if (!produto.disponivel()) {
                throw new RuntimeException("Produto " + produto.nome() + " não está disponível no momento");
            }

            double subtotal = produto.preco() * item.quantidade();
            totalDoPedido += subtotal;

            ItemPedido itemValidado = new ItemPedido(
                    null,
                    item.quantidade(),
                    produto.preco(),
                    null,
                    item.produtoId()
            );
            itensValidados.add(itemValidado);
        }

        Pedido pedidoCompleto = new Pedido(
                null,
                pedido.clienteId(),
                pedido.restauranteId(),
                null,
                itensValidados,
                totalDoPedido,
                StatusDoPedido.CRIADO,
                LocalDateTime.now(),
                pedido.enderecoCliente(),
                null,
                pedido.formaDePagamento(),
                null
        );

        Pedido pedidoSalvo = pedidoGateway.criarPedido(pedidoCompleto);

        notificationGateway.notificarPedidoCriado(pedidoSalvo);

        return pedidoSalvo;
    }
}
