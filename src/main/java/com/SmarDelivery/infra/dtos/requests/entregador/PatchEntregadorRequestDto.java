package com.SmarDelivery.infra.dtos.requests.entregador;

import com.SmarDelivery.domain.enums.MeioDeTransporte;

public record PatchEntregadorRequestDto(
        String nome,
        String email,
        String cpf,
        String telefone,
        MeioDeTransporte meioDeTransporte,
        Boolean disponivel,
        String localizacaoAtual) {
}
