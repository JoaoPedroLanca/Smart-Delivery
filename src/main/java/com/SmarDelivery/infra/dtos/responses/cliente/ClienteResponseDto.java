package com.SmarDelivery.infra.dtos.responses.cliente;

import com.SmarDelivery.domain.enums.Role;
import com.SmarDelivery.infra.dtos.responses.pedido.PedidoResponseDto;

import java.time.LocalDate;
import java.util.List;

public record ClienteResponseDto(Long clienteId,
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
