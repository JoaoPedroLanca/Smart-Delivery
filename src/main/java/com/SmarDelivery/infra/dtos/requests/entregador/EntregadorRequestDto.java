package com.SmarDelivery.infra.dtos.requests.entregador;

import com.SmarDelivery.domain.enums.MeioDeTransporte;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

public record EntregadorRequestDto(
        @NotBlank(message = "O nome não pode ser vazio")
        String nome,
        @Email(message = "Email inválido")
        String email,
        @CPF(message = "CPF inválido")
        String cpf,
        @Pattern(regexp = "\\(?\\d{2}\\)?\\s?9?\\d{4}-?\\d{4}", message = "Telefone inválido")
        String telefone,
        @NotNull(message = "O seu meio de transporte deve ser registrado")
        MeioDeTransporte meioDeTransporte,
        @NotNull(message = "Você deve registrar se está disponível para entregas")
        Boolean disponivel,
        @NotBlank(message = "A localização) atual não pode ser vazia")
        String localizacaoAtual){
}
