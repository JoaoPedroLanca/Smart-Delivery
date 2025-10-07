package com.SmarDelivery.domain.entities;

import com.SmarDelivery.domain.enums.MeioDeTransporte;
import com.SmarDelivery.domain.enums.Role;

import java.util.List;
import java.util.Locale;

public record Entregador(Long entregadorId,
                         String nome,
                         String email,
                         String cpf,
                         String telefone,
                         MeioDeTransporte meioDeTransporte,
                         boolean disponivel,
                         String localizacaoAtual,
                         Role role,
                         List<Pedido> pedidos) {
}
