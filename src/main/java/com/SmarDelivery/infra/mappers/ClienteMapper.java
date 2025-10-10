package com.SmarDelivery.infra.mappers;

import com.SmarDelivery.domain.entities.Cliente;
import com.SmarDelivery.infra.dtos.requests.ClienteRequestDto;
import com.SmarDelivery.infra.dtos.responses.ClienteResponseDto;
import com.SmarDelivery.infra.persistence.entities.ClienteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClienteMapper {

    @Mapping(target = "clienteId", ignore = true)
    @Mapping(target = "dataCadastro", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "pedidos", ignore = true)
    Cliente toDomain(ClienteRequestDto dto);

    ClienteEntity toEntity(Cliente domain);

    Cliente toDomain(ClienteEntity entity);

    ClienteResponseDto toResponse(Cliente domain);
}
