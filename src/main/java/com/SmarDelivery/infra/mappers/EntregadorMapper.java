package com.SmarDelivery.infra.mappers;

import com.SmarDelivery.domain.entities.Entregador;
import com.SmarDelivery.infra.dtos.requests.entregador.EntregadorRequestDto;
import com.SmarDelivery.infra.dtos.requests.entregador.PatchEntregadorRequestDto;
import com.SmarDelivery.infra.dtos.responses.entregador.EntregadorResponseDto;
import com.SmarDelivery.infra.persistence.entities.EntregadorEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EntregadorMapper {

    @Mapping(target = "entregadorId", ignore = true)
    @Mapping(target = "role", expression = "java(com.SmarDelivery.domain.enums.Role.ENTREGADOR)")
    @Mapping(target = "pedidos", ignore = true)
    Entregador toDomain(EntregadorRequestDto dto);

    EntregadorEntity toEntity(Entregador domain);

    Entregador toDomain(EntregadorEntity entity);

    @Mapping(target = "pedidos", expression = "java(java.util.List.of())")
    EntregadorResponseDto toResponse(Entregador domain);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Entregador updateEntregadorFromDto(PatchEntregadorRequestDto dto, @MappingTarget Entregador entregador);

    default Entregador patchToEntregador(PatchEntregadorRequestDto dto, Entregador original) {
        return new Entregador(
                original.entregadorId(),
                dto.nome() != null ? dto.nome() : original.nome(),
                dto.email() != null ? dto.email() : original.email(),
                dto.cpf() != null ? dto.cpf() : original.cpf(),
                dto.telefone() != null ? dto.telefone() : original.telefone(),
                dto.meioDeTransporte() != null ? dto.meioDeTransporte() : original.meioDeTransporte(),
                dto.disponivel() != null ? dto.disponivel() : original.disponivel(),
                original.localizacaoAtual(),
                original.role(),
                original.pedidos()
        );
    }
}