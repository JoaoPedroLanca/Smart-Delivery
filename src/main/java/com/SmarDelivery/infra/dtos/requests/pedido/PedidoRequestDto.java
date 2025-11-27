package com.SmarDelivery.infra.dtos.requests.pedido;

import com.SmarDelivery.domain.enums.FormaDePagamento;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record PedidoRequestDto(
        @NotNull(message = "O ID do cliente é obrigatório")
        Long clienteId, // TODO: Trocar pelo token JWT quando implementado
        
        @NotNull(message = "O ID do restaurante é obrigatório")
        Long restauranteId,
        
        @NotEmpty(message = "O pedido deve conter pelo menos um item")
        @Valid
        List<ItemPedidoRequestDto> itens,
        
        @NotNull(message = "O endereço do cliente é obrigatório")
        String enderecoCliente,
        
        @NotNull(message = "A forma de pagamento é obrigatória")
        FormaDePagamento formaDePagamento
) {}
