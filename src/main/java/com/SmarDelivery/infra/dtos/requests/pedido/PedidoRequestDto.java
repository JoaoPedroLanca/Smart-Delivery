package com.SmarDelivery.infra.dtos.requests.pedido;

import com.SmarDelivery.domain.enums.FormaDePagamento;

public record PedidoRequestDto(Long restauranteId,
                               /*List<ItemPedidoRequestDto> itensDoPedido,*/
                               FormaDePagamento formaDePagamento,
                               String enderecoCliente) {
}
