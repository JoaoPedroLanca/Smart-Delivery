package com.SmarDelivery.infra.gateway;

import com.SmarDelivery.domain.entities.Pedido;
import com.SmarDelivery.domain.gateway.pedido.PedidoGateway;
import com.SmarDelivery.infra.mappers.PedidoMapper;
import com.SmarDelivery.infra.persistence.repositories.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PedidoRepositoryGateway implements PedidoGateway {

    private final PedidoRepository pedidoRepository;
    private final PedidoMapper pedidoMapper;

    @Override
    public Pedido criarPedido(Pedido pedido) {
        var pedidoEntity = pedidoMapper.toEntity(pedido);
        var pedidoSalvo = pedidoRepository.save(pedidoEntity);

        return pedidoMapper.toDomain(pedidoSalvo);
    }
}
