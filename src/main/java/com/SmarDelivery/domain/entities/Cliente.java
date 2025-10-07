package com.SmarDelivery.domain.entities;

import com.SmarDelivery.domain.enums.Role;

import java.time.LocalDate;
import java.util.List;

public record Cliente(Long clienteId,
                      String nome,
                      String email,
                      String cpf,
                      String telefone,
                      String endereco,
                      String cep,
                      LocalDate dataCadastro,
                      Role role,
                      List<Pedido> pedidos) {
}
