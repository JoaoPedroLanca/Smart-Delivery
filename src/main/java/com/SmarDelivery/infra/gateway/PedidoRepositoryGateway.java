package com.SmarDelivery.infra.gateway;

import com.SmarDelivery.domain.entities.Pedido;
import com.SmarDelivery.domain.gateway.PedidoGateway;
import com.SmarDelivery.infra.dtos.requests.pedido.PatchPedidoRequestDto;
import com.SmarDelivery.infra.mappers.PedidoMapper;
import com.SmarDelivery.infra.persistence.entities.PedidoEntity;
import com.SmarDelivery.infra.persistence.repositories.PedidoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class PedidoRepositoryGateway implements PedidoGateway {

    private final PedidoRepository pedidoRepository;
    private final PedidoMapper pedidoMapper;

    @Override
    public Pedido criarPedido(Pedido pedido) {
        var pedidoEntity = pedidoMapper.toEntity(pedido);
        
        // Garante que os itens tenham referência ao pedido
        if (pedidoEntity.getItensDoPedido() != null) {
            pedidoEntity.getItensDoPedido().forEach(item -> item.setPedido(pedidoEntity));
        }
        
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

    @Transactional
    @Override
    public Pedido atualizarPedido(Long pedidoId, Map<String, Object> atualizacao) {
        PedidoEntity pedidoEntity = pedidoRepository.findById(pedidoId).orElseThrow(() -> new RuntimeException("Pedido " + pedidoId + " não encontrado em sistema para atualização"));
        Pedido pedidoDomain = pedidoMapper.toDomain(pedidoEntity);
        ObjectMapper objectMapper = new ObjectMapper();
        PatchPedidoRequestDto patchDto = objectMapper.convertValue(atualizacao, PatchPedidoRequestDto.class);
        Pedido pedidoAtualizado = merge(patchDto, pedidoDomain);
        PedidoEntity pedidoAtualizadoEntity = pedidoMapper.toEntity(pedidoAtualizado);
        PedidoEntity novoPedido = pedidoRepository.save(pedidoAtualizadoEntity);

        return pedidoMapper.toDomain(novoPedido);
    }

    private Pedido merge(PatchPedidoRequestDto patchDto, Pedido pedido) {
        return pedidoMapper.patchToPedido(patchDto, pedido);
    }
}
