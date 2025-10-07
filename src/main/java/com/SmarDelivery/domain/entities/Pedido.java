package com.SmarDelivery.domain.entities;

import com.SmarDelivery.domain.enums.FormaDePagamento;
import com.SmarDelivery.domain.enums.StatusDoPedido;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public record Pedido(Long id,
                     Long clienteId,
                     Long restauranteId,
                     List<String> itensDoPedido,
                     int totalDoPedido,
                     StatusDoPedido statusPedido,
                     LocalDateTime criacaoDoPedido,
                     Long entregadorId,
                     String enderecoCliente,
                     String distancia,
                     FormaDePagamento formaDePagamento,
                     Duration tempoEstimadoDeEntrega) {
}
