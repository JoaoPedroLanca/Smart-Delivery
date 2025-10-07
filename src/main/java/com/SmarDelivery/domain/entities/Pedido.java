package com.SmarDelivery.domain.entities;

import com.SmarDelivery.domain.enums.FormaDePagamento;
import com.SmarDelivery.domain.enums.StatusDoPedido;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public record Pedido(Long pedidoId,
                     Long clienteId,
                     Long restauranteId,
                     Long entregadorId,
                     List<ItemPedido> itensDoPedido,
                     double totalDoPedido,
                     StatusDoPedido statusPedido,
                     LocalDateTime criacaoDoPedido,
                     String enderecoCliente,
                     String distancia,
                     FormaDePagamento formaDePagamento,
                     Long tempoEstimadoDeEntrega) {
}
