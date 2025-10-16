package com.SmarDelivery.infra.dtos.responses.pedido;

import com.SmarDelivery.domain.enums.FormaDePagamento;
import com.SmarDelivery.domain.enums.StatusDoPedido;

import java.time.LocalDateTime;

public record PedidoResponseDto(Long pedidoId,
                                Long clienteId,
                                Long restauranteId,
                                Long entregadorId,
                                /*List<ItemPedidoResponseDto> itensDoPedido,*/
                                double totalDoPedido,
                                StatusDoPedido statusPedido,
                                LocalDateTime criacaoDoPedido,
                                String enderecoCliente,
                                String distancia,
                                FormaDePagamento formaDePagamento,
                                Long tempoEstimadoDeEntrega) {
}
