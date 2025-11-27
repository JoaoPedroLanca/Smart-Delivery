package com.SmarDelivery.infra.gateway;

import com.SmarDelivery.domain.entities.Pedido;
import com.SmarDelivery.domain.gateway.PedidoGateway;
import com.SmarDelivery.infra.mappers.PedidoMapper;
import com.SmarDelivery.infra.persistence.entities.PedidoEntity;
import com.SmarDelivery.infra.persistence.repositories.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Pedido> buscarPedidoPorId(Long pedidoId) {
        Optional<PedidoEntity> pedido = pedidoRepository.findById(pedidoId);
        return pedido.map(pedidoMapper::toDomain);
    }

    @Override
    public List<Pedido> buscarTodosPedidos() {
        List<PedidoEntity> pedidos = pedidoRepository.findAll();
        return pedidos
                .stream()
                .map(pedidoMapper::toDomain)
                .toList();
    }
}
