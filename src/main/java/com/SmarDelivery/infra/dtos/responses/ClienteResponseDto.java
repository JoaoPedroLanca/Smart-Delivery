package com.SmarDelivery.infra.dtos.responses;

import com.SmarDelivery.domain.enums.Role;

import java.time.LocalDate;
import java.util.List;

public record ClienteResponseDto(Long id,
                                 String nome,
                                 String email,
                                 String cpf,
                                 String telefone,
                                 String endereco,
                                 String cep,
                                 LocalDate dataCadastro,
                                 Role role,
                                 List<PedidoResponseDto> pedidos) {
}
