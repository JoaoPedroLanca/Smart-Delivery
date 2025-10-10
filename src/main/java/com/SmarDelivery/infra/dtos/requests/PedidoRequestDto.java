package com.SmarDelivery.infra.dtos.requests;

import com.SmarDelivery.domain.enums.FormaDePagamento;

import java.util.List;

public record PedidoRequestDto(Long restauranteId,
                               List<ItemPedidoRequestDto> itensDoPedido,
                               FormaDePagamento formaDePagamento,
                               String enderecoCliente) {
}
