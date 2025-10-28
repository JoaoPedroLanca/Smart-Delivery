package com.SmarDelivery.infra.dtos.responses.entregador;

import com.SmarDelivery.infra.dtos.responses.pedido.PedidoResponseDto;

import java.util.List;

public record EntregadorResponseDto(
        Long entregadorId,
        String nome,
        String email,
        String cpf,
        String telefone,
        String meioDeTransporte,
        boolean disponivel,
        String localizacaoAtual,
        String role,
        List<PedidoResponseDto> pedidos
) {
}
