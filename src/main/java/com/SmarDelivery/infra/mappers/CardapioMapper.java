package com.SmarDelivery.infra.mappers;

import com.SmarDelivery.domain.entities.Cardapio;
import com.SmarDelivery.infra.dtos.requests.cardapio.CardapioRequestDto;
import com.SmarDelivery.infra.dtos.requests.cardapio.PatchCardapioRequestDto;
import com.SmarDelivery.infra.dtos.responses.cardapio.CardapioResponseDto;
import com.SmarDelivery.infra.persistence.entities.CardapioEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface CardapioMapper {

    @Mapping(target = "produtoId", ignore = true)
    @Mapping(target = "restaurante_id", source = "restauranteId")
    Cardapio toDomain(CardapioRequestDto dto);

    @Mapping(target = "restaurante", ignore = true)
    CardapioEntity toEntity(Cardapio domain);

    @Mapping(target = "restaurante_id", source = "restaurante.restauranteId")
    Cardapio toDomain(CardapioEntity entity);

    CardapioResponseDto toResponse(Cardapio domain);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Cardapio updateCardapioFromDto(PatchCardapioRequestDto dto, @MappingTarget Cardapio cardapio);

    default Cardapio patchToCardapio(PatchCardapioRequestDto dto, Cardapio original) {
        return new Cardapio(
                original.produtoId(),
                dto.nome() != null ? dto.nome() : original.nome(),
                dto.preco() != 0.0 ? dto.preco() : original.preco(),
                dto.disponivel(),
                dto.restauranteId() != null ? dto.restauranteId() : original.restaurante_id()
        );
    }
}
