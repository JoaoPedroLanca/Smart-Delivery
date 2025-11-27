package com.SmarDelivery.infra.presentation;

import com.SmarDelivery.domain.entities.Pedido;
import com.SmarDelivery.domain.usecases.pedido.BuscarPedidoPorIdUsecase;
import com.SmarDelivery.domain.usecases.pedido.BuscarTodosPedidosUsecase;
import com.SmarDelivery.domain.usecases.pedido.CriarPedidoUsecase;
import com.SmarDelivery.infra.dtos.requests.pedido.PedidoRequestDto;
import com.SmarDelivery.infra.dtos.responses.pedido.PedidoResponseDto;
import com.SmarDelivery.infra.mappers.PedidoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final CriarPedidoUsecase criarPedidoUsecase;
    private final BuscarPedidoPorIdUsecase buscarPedidoPorIdUsecase;
    private final BuscarTodosPedidosUsecase buscarTodosPedidosUsecase;
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
}