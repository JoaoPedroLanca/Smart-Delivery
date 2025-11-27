package com.SmarDelivery.infra.mappers;

import com.SmarDelivery.domain.entities.ItemPedido;
import com.SmarDelivery.infra.persistence.entities.CardapioEntity;
import com.SmarDelivery.infra.persistence.entities.ItemPedidoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ItemPedidoMapper {

    @Mapping(target = "pedido", ignore = true) // Será preenchido pelo PedidoEntity
    @Mapping(target = "produto.produtoId", source = "produtoId")
    ItemPedidoEntity toEntity(ItemPedido domain);

    @Mapping(target = "pedidoId", expression = "java(entity.getPedido() != null ? entity.getPedido().getPedidoId() : null)")
    @Mapping(target = "produtoId", source = "produto.produtoId")
    ItemPedido toDomain(ItemPedidoEntity entity);
}

