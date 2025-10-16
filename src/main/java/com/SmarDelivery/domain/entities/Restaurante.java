package com.SmarDelivery.domain.entities;

import java.time.LocalDateTime;
import java.util.List;

public record Restaurante(Long restauranteId,
                          String nome,
                          String cnpj,
                          String endereco,
                          String cep,
                          String telefone,
                          boolean aberto,
                          LocalDateTime horarioAbertura,
                          LocalDateTime horarioFechamento,
                          List<Cardapio> cardapio,
                          List<Pedido> pedidos) {
}
