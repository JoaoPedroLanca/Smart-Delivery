package com.SmarDelivery.infra.presentation;

import com.SmarDelivery.domain.entities.Pedido;
import com.SmarDelivery.domain.usecases.pedido.*;
import com.SmarDelivery.infra.dtos.requests.pedido.AceitarPedidoRequestDto;
import com.SmarDelivery.infra.dtos.requests.pedido.PedidoRequestDto;
import com.SmarDelivery.infra.dtos.responses.pedido.PedidoResponseDto;
import com.SmarDelivery.infra.mappers.PedidoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final CriarPedidoUsecase criarPedidoUsecase;
    private final BuscarPedidoPorIdUsecase buscarPedidoPorIdUsecase;
    private final BuscarTodosPedidosUsecase buscarTodosPedidosUsecase;
    private final AtualizarPedidoUsecase atualizarPedidoUsecase;
    private final AceitarPedidoRestauranteUsecase aceitarPedidoRestauranteUsecase;
    private final AceitarPedidoEntregadorUsecase aceitarPedidoEntregadorUsecase;
    private final PedidoMapper pedidoMapper;

    @GetMapping
    public ResponseEntity<List<PedidoResponseDto>> buscarTodosPedidos() {
        List<Pedido> pedidos = buscarTodosPedidosUsecase.execute();
        List<PedidoResponseDto> pedidoResponse = pedidos
                .stream()
                .map(pedidoMapper::toResponse)
                .toList();

        return ResponseEntity.ok(pedidoResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDto> buscarPedidoPorId(@PathVariable Long id) {
        Pedido pedido = buscarPedidoPorIdUsecase.execute(id);
        PedidoResponseDto pedidoResponse = pedidoMapper.toResponse(pedido);

        return ResponseEntity.ok(pedidoResponse);
    }

    @PostMapping
    public ResponseEntity<PedidoResponseDto> criarPedido(@RequestBody PedidoRequestDto requestDto) {
        var pedidoDomain = pedidoMapper.toDomain(requestDto);
        var pedidoResponse = pedidoMapper.toResponse(criarPedidoUsecase.execute(pedidoDomain));

        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoResponse);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PedidoResponseDto> patchPedido(@PathVariable Long id, @RequestBody Map<String, Object> atualizacao) {
        var pedidoResponse = pedidoMapper.toResponse(atualizarPedidoUsecase.execute(id, atualizacao));

        return ResponseEntity.ok(pedidoResponse);
    }

    @PatchMapping("/{id}/restaurante/aceitar")
    public ResponseEntity<PedidoResponseDto> aceitarPedidoRestaurante(@PathVariable Long id) {
        var aceitarPedido = aceitarPedidoRestauranteUsecase.execute(id);
        PedidoResponseDto response = pedidoMapper.toResponse(aceitarPedido);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/entregador/aceitar")
    public ResponseEntity<PedidoResponseDto> aceitarPedidoEntregador(
            @PathVariable Long id,
            @RequestBody AceitarPedidoRequestDto requestDto) {
        var aceitarEntrega = aceitarPedidoEntregadorUsecase.execute(id, requestDto.entregadorId());
        var response = pedidoMapper.toResponse(aceitarEntrega);
        return ResponseEntity.ok(response);
    }
}