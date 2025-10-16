package com.SmarDelivery.infra.dtos.requests.restaurante;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CNPJ;

import java.time.LocalDateTime;

public record RestauranteRequestDto(
        @NotBlank(message = "O nome do restaurante não pode ser vázio") String nome,
        @CNPJ(message = "CNPJ inválido") String cnpj,
        @NotBlank(message = "O endereço não pode ser vazio") String endereco,
        @Pattern(regexp = "\\d{5}-?\\d{3}", message = "CEP inválido") String cep,
        @Pattern(regexp = "\\(?\\d{2}\\)?\\s?9?\\d{4}-?\\d{4}", message = "Telefone inválido") String telefone,
        @NotBlank(message = "O status de aberto ou fechado deve ser passado") boolean aberto,
        @NotBlank(message = "O horário de abertura deve ser registrado") LocalDateTime horarioAbertura,
        @NotBlank(message = "O horário de fechamento deve ser registrado") LocalDateTime horarioFechamento
) {
}
