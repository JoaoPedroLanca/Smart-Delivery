package com.SmarDelivery.infra.mappers;

import com.SmarDelivery.domain.entities.Cliente;
import com.SmarDelivery.infra.dtos.requests.cliente.ClienteRequestDto;
import com.SmarDelivery.infra.dtos.requests.cliente.PatchClienteRequestDto;
import com.SmarDelivery.infra.dtos.responses.cliente.ClienteResponseDto;
import com.SmarDelivery.infra.persistence.entities.ClienteEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClienteMapper {

    @Mapping(target = "clienteId", ignore = true)
    @Mapping(target = "dataCadastro", expression = "java(java.time.LocalDate.now())")
    @Mapping(target = "role", expression = "java(com.SmarDelivery.domain.enums.Role.CLIENTE)")
    @Mapping(target = "pedidos", ignore = true)
    Cliente toDomain(ClienteRequestDto dto);

    ClienteEntity toEntity(Cliente domain);

    Cliente toDomain(ClienteEntity entity);

    ClienteResponseDto toResponse(Cliente domain);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Cliente updateClienteFromDto(PatchClienteRequestDto dto, @MappingTarget Cliente cliente);

    // Atualização manual para record imutável
    default Cliente patchToCliente(PatchClienteRequestDto dto, Cliente original) {
        return new Cliente(
            original.clienteId(),
            dto.nome() != null ? dto.nome() : original.nome(),
            dto.email() != null ? dto.email() : original.email(),
            dto.cpf() != null ? dto.cpf() : original.cpf(),
            dto.telefone() != null ? dto.telefone() : original.telefone(),
            dto.endereco() != null ? dto.endereco() : original.endereco(),
            dto.cep() != null ? dto.cep() : original.cep(),
            original.dataCadastro(),
            original.role(),
            original.pedidos()
        );
    }
}
