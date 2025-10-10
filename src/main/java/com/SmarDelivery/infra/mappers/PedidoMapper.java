package com.SmarDelivery.infra.mappers;

import com.SmarDelivery.domain.entities.ItemPedido;
import com.SmarDelivery.domain.entities.Pedido;
import com.SmarDelivery.infra.dtos.requests.PedidoRequestDto;
import com.SmarDelivery.infra.dtos.responses.PedidoResponseDto;
import com.SmarDelivery.infra.persistence.entities.PedidoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PedidoMapper {


    /*
    * Fonte: DTO de Requisição o PedidoRequestDto (Camada Externa)
    * Destino: Record de Domínio o Pedido (Camada Pura)
    * */

    @Mapping(target = "pedidoId", ignore = true)
    @Mapping(target = "clienteId", ignore = true)
    @Mapping(target = "entregadorId", ignore = true)
    @Mapping(target = "totalDoPedido", ignore = true)
    @Mapping(target = "statusPedido", ignore = true)
    @Mapping(target = "criacaoDoPedido", ignore = true)
    @Mapping(target = "distancia", ignore = true)
    @Mapping(target = "tempoEstimadoDeEntrega", ignore = true)
    Pedido toDomain(PedidoRequestDto dto);

    /*
    * Fonte: Record de Domínio o Pedido (Camada Pura)
    * Destino: Entity JPA o PedidoEntity(Camada de Persistência)
    * Mapeando IDs puros do Domain para os objetos Entity (para o JPA)
    * */

    @Mapping(target = "cliente.clienteId", source = "clienteId")
    @Mapping(target = "restaurante.restauranteId", source = "restauranteId")
    @Mapping(target = "entregador.entregadorId", source = "entregadorId")
    PedidoEntity toEntity(Pedido domain);

    /*
    * Fonte: Entity JPA o PedidoEntity (Camada de Persistência)
    * Destino: Record de Domínio o Pedido (Camada Pura)
    * Mapeando os IDs das Entities de volta para Longs puros no Domain.
    * */

    @Mapping(target = "clienteId", source = "cliente.clienteId")
    @Mapping(target = "restauranteId", source = "restaurante.restauranteId")
    @Mapping(target = "entregadorId", source = "entregador.entregadorId")
    Pedido toDomain(PedidoEntity entity);

    /*
    * Fonte: Record de Domínio o Pedido (Camada Pura, após processamento)
    * Destino: DTO de Resposta o PedidoResponseDto(Camada Externa) que será retornado ao usuário
    * */

    PedidoResponseDto toResponse(Pedido domain);
}
