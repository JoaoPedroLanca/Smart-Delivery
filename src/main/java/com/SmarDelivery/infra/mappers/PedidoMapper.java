package com.SmarDelivery.infra.mappers;

import com.SmarDelivery.domain.entities.ItemPedido;
import com.SmarDelivery.domain.entities.Pedido;
import com.SmarDelivery.infra.dtos.requests.pedido.ItemPedidoRequestDto;
import com.SmarDelivery.infra.dtos.requests.pedido.PatchPedidoRequestDto;
import com.SmarDelivery.infra.dtos.requests.pedido.PedidoRequestDto;
import com.SmarDelivery.infra.dtos.responses.pedido.PedidoResponseDto;
import com.SmarDelivery.infra.persistence.entities.ItemPedidoEntity;
import com.SmarDelivery.infra.persistence.entities.PedidoEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {ItemPedidoMapper.class})
public interface PedidoMapper {


    /*
    * Fonte: DTO de Requisição o PedidoRequestDto (Camada Externa)
    * Destino: Record de Domínio o Pedido (Camada Pura)
    * */

    @Mapping(target = "pedidoId", ignore = true)
    @Mapping(target = "entregadorId", ignore = true)
    @Mapping(target = "itensDoPedido", source = "itens")
    @Mapping(target = "totalDoPedido", ignore = true)
    @Mapping(target = "statusPedido", ignore = true)
    @Mapping(target = "criacaoDoPedido", ignore = true)
    @Mapping(target = "distancia", ignore = true)
    @Mapping(target = "tempoEstimadoDeEntrega", ignore = true)
    Pedido toDomain(PedidoRequestDto dto);

    /*
     * Converte ItemPedidoRequestDto para ItemPedido (Domain)
     * O preço unitário será preenchido no Use Case após buscar o produto
     */
    default ItemPedido itemPedidoRequestToDomain(ItemPedidoRequestDto dto) {
        return new ItemPedido(
                null, // itemId será gerado pelo banco
                dto.quantidade(),
                0.0, // precoUnitario será preenchido no Use Case
                null, // pedidoId será preenchido depois
                dto.produtoId()
        );
    }

    default List<ItemPedido> itemPedidoRequestListToDomain(List<ItemPedidoRequestDto> dtos) {
        return dtos.stream()
                .map(this::itemPedidoRequestToDomain)
                .toList();
    }

    /*
    * Fonte: Record de Domínio o Pedido (Camada Pura)
    * Destino: Entity JPA o PedidoEntity(Camada de Persistência)
    * Mapeando IDs puros do Domain para os objetos Entity (para o JPA)
    * */

    @Mapping(target = "cliente.clienteId", source = "clienteId")
    @Mapping(target = "restaurante.restauranteId", source = "restauranteId")
    @Mapping(target = "entregador.entregadorId", source = "entregadorId")
    @Mapping(target = "itensDoPedido", source = "itensDoPedido")
    PedidoEntity toEntity(Pedido domain);

    /*
    * Fonte: Entity JPA o PedidoEntity (Camada de Persistência)
    * Destino: Record de Domínio o Pedido (Camada Pura)
    * Mapeando os IDs das Entities de volta para Longs puros no Domain.
    * */

    @Mapping(target = "clienteId", source = "cliente.clienteId")
    @Mapping(target = "restauranteId", source = "restaurante.restauranteId")
    @Mapping(target = "entregadorId", expression = "java(entity.getEntregador() != null ? entity.getEntregador().getEntregadorId() : null)")
    @Mapping(target = "itensDoPedido", source = "itensDoPedido")
    Pedido toDomain(PedidoEntity entity);

    /*
    * Fonte: Record de Domínio o Pedido (Camada Pura, após processamento)
    * Destino: DTO de Resposta o PedidoResponseDto(Camada Externa) que será retornado ao usuário
    * */

    PedidoResponseDto toResponse(Pedido domain);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Pedido updatePedidoFromDto(PatchPedidoRequestDto dto, @MappingTarget Pedido pedido);

    // Atualização manual para record imutável
    default Pedido patchToPedido(PatchPedidoRequestDto dto, Pedido original) {
        return new Pedido(
                original.pedidoId(),
                original.clienteId(),
                original.restauranteId(),
                original.entregadorId(),
                original.itensDoPedido(),
                original.totalDoPedido(),
                dto.statusPedido() != null ? dto.statusPedido() : original.statusPedido(),
                original.criacaoDoPedido(),
                original.enderecoCliente(),
                original.distancia(),
                original.formaDePagamento(),
                original.tempoEstimadoDeEntrega()
        );
    }
}
