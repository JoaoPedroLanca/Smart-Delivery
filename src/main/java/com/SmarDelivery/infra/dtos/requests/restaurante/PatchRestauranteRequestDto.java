package com.SmarDelivery.infra.dtos.requests.restaurante;

public record PatchRestauranteRequestDto(
        String nome,
        String cnpj,
        String telefone,
        String endereco,
        String cep,
        Boolean aberto,
        String horarioAbertura,
        String horarioFechamento
) {
}
