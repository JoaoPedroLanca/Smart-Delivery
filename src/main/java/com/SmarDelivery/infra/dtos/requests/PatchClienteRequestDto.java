package com.SmarDelivery.infra.dtos.requests;

import java.util.Optional;

public record PatchClienteRequestDto (String nome,
                                      String email,
                                      String cpf,
                                      String telefone,
                                      String endereco,
                                      String cep) {
}

