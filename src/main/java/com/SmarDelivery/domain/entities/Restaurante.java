package com.SmarDelivery.domain.entities;

import java.time.LocalDateTime;
import java.util.List;

public record Restaurante(Long id,
                          String nome,
                          String cnpj,
                          String endereco,
                          String cep,
                          String telefone,
                          List<String> cardapido,
                          boolean aberto,
                          LocalDateTime horarioAbertura,
                          LocalDateTime horarioFechamento,
                          Long pedidoId) {
}
