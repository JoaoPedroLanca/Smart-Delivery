package com.SmarDelivery.infra.mappers;

import com.SmarDelivery.domain.entities.Cardapio;
import com.SmarDelivery.domain.entities.Cliente;
import com.SmarDelivery.infra.dtos.requests.cardapio.CardapioRequestDto;
import com.SmarDelivery.infra.dtos.requests.cardapio.PatchCardapioRequestDto;
import com.SmarDelivery.infra.dtos.responses.cardapio.CardapioResponseDto;
import com.SmarDelivery.infra.persistence.entities.CardapioEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface CardapioMapper {

    Cardapio toDomain(CardapioRequestDto dto);

    CardapioEntity toEntity(Cardapio domain);

    Cardapio toDomain(CardapioEntity entity);

    CardapioResponseDto toResponse(Cardapio domain);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Cardapio updateCardapioFromDto(PatchCardapioRequestDto dto, @MappingTarget Cliente cliente);

    default Cardapio patchToCardapio(PatchCardapioRequestDto dto, Cardapio original) {
        return new Cardapio(
            original.produtoId(),
            dto.nome() != null ? dto.nome() : original.nome(),
            original.preco(),
            original.disponivel(),
            original.restaurante_id()
        );
    }
}
