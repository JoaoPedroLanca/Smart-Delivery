package com.SmarDelivery.infra.presentation;

import com.SmarDelivery.domain.entities.Entregador;
import com.SmarDelivery.domain.usecases.entregador.AtualizarEntregadorUsecase;
import com.SmarDelivery.domain.usecases.entregador.BuscarEntregadorPorIdUsecase;
import com.SmarDelivery.domain.usecases.entregador.BuscarTodosEntregadoresUsecase;
import com.SmarDelivery.domain.usecases.entregador.CriarEntregadorUsecase;
import com.SmarDelivery.infra.dtos.requests.entregador.EntregadorRequestDto;
import com.SmarDelivery.infra.dtos.responses.entregador.EntregadorResponseDto;
import com.SmarDelivery.infra.mappers.EntregadorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/entregador")
public class EntregadorController {

    private final CriarEntregadorUsecase criarEntregadorUsecase;
    private final BuscarTodosEntregadoresUsecase buscarTodosEntregadoresUsecase;
    private final BuscarEntregadorPorIdUsecase buscarEntregadorPorIdUsecase;
    private final AtualizarEntregadorUsecase atualizarEntregadorUsecase;
    private final EntregadorMapper entregadorMapper;

    @PostMapping
    public ResponseEntity<EntregadorResponseDto> criarEntregador(@RequestBody EntregadorRequestDto requestDto) {
        var entregadorDomain = entregadorMapper.toDomain(requestDto);
        var novoEntregador = criarEntregadorUsecase.execute(entregadorDomain);
        var responseDto = entregadorMapper.toResponse(novoEntregador);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<EntregadorResponseDto>> buscarTodosEntregadores() {
        List<Entregador> entregadores = buscarTodosEntregadoresUsecase.execute();
        List<EntregadorResponseDto> entregadorResponse = entregadores
                .stream()
                .map(entregadorMapper::toResponse)
                .toList();
        return ResponseEntity.ok(entregadorResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntregadorResponseDto> buscarEntregadorPorId(@PathVariable Long id) {
        Entregador entregador = buscarEntregadorPorIdUsecase.execute(id);
        EntregadorResponseDto entregadorResponse = entregadorMapper.toResponse(entregador);

        return ResponseEntity.ok(entregadorResponse);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EntregadorResponseDto> atualizarEntregador(@PathVariable Long id, @RequestBody Map<String, Object> atualizacao) {
        EntregadorResponseDto entregadorResponse = entregadorMapper.toResponse(atualizarEntregadorUsecase.execute(id, atualizacao));

        return ResponseEntity.ok(entregadorResponse);
    }
}
