package com.SmarDelivery.domain.entities;

import com.SmarDelivery.domain.enums.MeioDeTransporte;
import com.SmarDelivery.domain.enums.Role;

import java.util.Locale;

public record Entregador(Long id,
                         String nome,
                         String email,
                         String cpf,
                         String telefone,
                         MeioDeTransporte meioDeTransporte,
                         boolean disponivel,
                         Locale localizacaoAtual,
                         Role role,
                         Long pedidoId) {
}
