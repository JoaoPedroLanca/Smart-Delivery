package com.SmarDelivery.infra.mappers;

import com.SmarDelivery.domain.entities.Restaurante;
import com.SmarDelivery.infra.dtos.requests.restaurante.RestauranteRequestDto;
import com.SmarDelivery.infra.dtos.requests.restaurante.PatchRestauranteRequestDto;
import com.SmarDelivery.infra.dtos.responses.restaurante.RestauranteResponseDto;
import com.SmarDelivery.infra.persistence.entities.RestauranteEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestauranteMapper {

    @Mapping(target = "restauranteId", ignore = true)
    @Mapping(target = "cardapio", ignore = true)
    @Mapping(target = "pedidos", ignore = true)
    Restaurante toDomain(RestauranteRequestDto dto);

    RestauranteEntity toEntity(Restaurante domain);

    Restaurante toDomain(RestauranteEntity entity);

    RestauranteResponseDto toResponse(Restaurante domain);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Restaurante updateRestauranteFromDto(PatchRestauranteRequestDto dto, @MappingTarget Restaurante restaurante);

    default Restaurante patchToRestaurante(PatchRestauranteRequestDto dto, Restaurante original) {
        return new Restaurante(
            original.restauranteId(),
            dto.nome() != null ? dto.nome() : original.nome(),
            dto.cnpj() != null ? dto.cnpj() : original.cnpj(),
            dto.telefone() != null ? dto.telefone() : original.telefone(),
            dto.endereco() != null ? dto.endereco() : original.endereco(),
            dto.cep() != null ? dto.cep() : original.cep(),
            dto.aberto() != null ? dto.aberto() : original.aberto(),
            dto.horarioAbertura() != null ? java.time.LocalDateTime.parse(dto.horarioAbertura()) : original.horarioAbertura(),
            dto.horarioFechamento() != null ? java.time.LocalDateTime.parse(dto.horarioFechamento()) : original.horarioFechamento(),
            original.cardapio(),
            original.pedidos()
        );
    }
}
