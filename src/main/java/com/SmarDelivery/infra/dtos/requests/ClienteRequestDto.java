package com.SmarDelivery.infra.dtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

public record ClienteRequestDto(
        @NotBlank(message = "O nome não pode ser vazio") String nome,
        @Email(message = "Email inválido") String email,
        @CPF(message = "CPF inválido") String cpf,
        @Pattern(regexp = "\\(?\\d{2}\\)?\\s?9?\\d{4}-?\\d{4}", message = "Telefone inválido") String telefone,
        @NotBlank(message = "O endereço não pode ser vazio") String endereco,
        @Pattern(regexp = "\\d{5}-?\\d{3}", message = "CEP inválido") String cep) {
}
