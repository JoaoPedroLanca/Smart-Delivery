package com.SmarDelivery.domain.entities;

import com.SmarDelivery.domain.enums.Role;

import java.time.LocalDate;

public record Cliente(Long id,
                      String nome,
                      String email,
                      String cpf,
                      String telefone,
                      String endereco,
                      String cep,
                      LocalDate dataCadastro,
                      Role role) {
}
