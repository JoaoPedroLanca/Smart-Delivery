package com.SmarDelivery.infra.dtos.responses;

import com.SmarDelivery.domain.enums.FormaDePagamento;
import com.SmarDelivery.domain.enums.StatusDoPedido;

import java.time.LocalDateTime;
import java.util.List;

public record PedidoResponseDto(Long pedidoId,
                                Long clienteId,
                                Long restauranteId,
                                Long entregadorId,
                                List<ItemPedidoResponseDto> itensDoPedido,
                                double totalDoPedido,
                                StatusDoPedido statusPedido,
                                LocalDateTime criacaoDoPedido,
                                String enderecoCliente,
                                String distancia,
                                FormaDePagamento formaDePagamento,
                                Long tempoEstimadoDeEntrega) {
}
