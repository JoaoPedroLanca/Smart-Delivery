package com.SmarDelivery.infra.mappers;

import com.SmarDelivery.domain.entities.Cardapio;
import com.SmarDelivery.infra.dtos.requests.cardapio.CardapioRequestDto;
import com.SmarDelivery.infra.dtos.requests.cardapio.PatchCardapioRequestDto;
import com.SmarDelivery.infra.dtos.responses.cardapio.CardapioResponseDto;
import com.SmarDelivery.infra.persistence.entities.CardapioEntity;
import com.SmarDelivery.infra.persistence.entities.RestauranteEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface CardapioMapper {

    @Mapping(target = "produtoId", ignore = true)
    @Mapping(target = "restaurante_id", source = "restauranteId")
    Cardapio toDomain(CardapioRequestDto dto);

    @Mapping(target = "restaurante", source = "restaurante_id", qualifiedByName = "restauranteFromId")
    CardapioEntity toEntity(Cardapio domain);

    @Mapping(target = "restaurante_id", source = "restaurante.restauranteId")
    Cardapio toDomain(CardapioEntity entity);

    @Mapping(target = "produtoId", source = "produtoId")
    CardapioResponseDto toResponse(Cardapio domain);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Cardapio updateCardapioFromDto(PatchCardapioRequestDto dto, @MappingTarget Cardapio cardapio);

    default Cardapio patchToCardapio(PatchCardapioRequestDto dto, Cardapio original) {
        return new Cardapio(
                original.produtoId(),
                dto.nome() != null ? dto.nome() : original.nome(),
                dto.preco() != null ? dto.preco() : original.preco(),
                dto.disponivel() != null ? dto.disponivel() : original.disponivel(),
                original.restaurante_id()
        );
    }

    @Named("restauranteFromId")
    default RestauranteEntity restauranteFromId(Long id) {
        if (id == null) return null;
        RestauranteEntity restaurante = new RestauranteEntity();
        restaurante.setRestauranteId(id);
        return restaurante;
    }
}
