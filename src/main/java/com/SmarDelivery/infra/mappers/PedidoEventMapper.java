package com.SmarDelivery.infra.mappers;

import com.SmarDelivery.domain.events.PedidoEvent;
import com.SmarDelivery.infra.dtos.events.PedidoEventDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PedidoEventMapper {

    PedidoEventDto toDto(PedidoEvent pedidoEvent);
}