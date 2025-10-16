package com.SmarDelivery.infra.dtos.requests.cliente;

public record PatchClienteRequestDto (String nome,
                                      String email,
                                      String cpf,
                                      String telefone,
                                      String endereco,
                                      String cep) {
}

