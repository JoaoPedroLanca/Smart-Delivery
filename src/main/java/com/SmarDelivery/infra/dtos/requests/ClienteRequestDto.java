package com.SmarDelivery.infra.dtos.requests;

public record ClienteRequestDto(String nome,
                                String email,
                                String cpf,
                                String telefone,
                                String endereco,
                                String cep) {
}
