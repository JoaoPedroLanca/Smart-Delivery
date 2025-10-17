package com.SmarDelivery.infra.dtos.responses.restaurante;

import com.SmarDelivery.infra.dtos.responses.pedido.PedidoResponseDto;

import java.time.LocalDateTime;
import java.util.List;

public record RestauranteResponseDto(
        Long restauranteId,
        String nome,
        String cnpj,
        String endereco,
        String cep,
        String telefone,
        boolean aberto,
        LocalDateTime horarioAbertura,
        LocalDateTime horarioFechamento,
        /*List<CardapioResponseDto> cardapio,*/
        List<PedidoResponseDto> pedidos
) {
}
