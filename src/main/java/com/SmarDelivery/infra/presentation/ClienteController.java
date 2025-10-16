package com.SmarDelivery.infra.presentation;

import com.SmarDelivery.domain.entities.Cliente;
import com.SmarDelivery.domain.usecases.cliente.*;
import com.SmarDelivery.infra.dtos.requests.ClienteRequestDto;
import com.SmarDelivery.infra.dtos.requests.PatchClienteRequestDto;
import com.SmarDelivery.infra.dtos.responses.ClienteResponseDto;
import com.SmarDelivery.infra.mappers.ClienteMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final AtualizarClienteUsecase atualizarClienteUsecase;
    private final BuscarClientePorIdUsecase buscarClientePorIdUsecase;
    private final BuscarTodosOsClientes buscarTodosOsClientes;
    private final CriarClienteUseCase criarClienteUseCase;
    private final DeletarClientePorId deletarClientePorId;
    private final ClienteMapper clienteMapper;

    @GetMapping
    public ResponseEntity<List<ClienteResponseDto>> buscarTodosOsClientes() {
        List<Cliente> clientes = buscarTodosOsClientes.execute();
        List<ClienteResponseDto> clienteResponse = clientes
                .stream()
                .map(clienteMapper::toResponse)
                .toList();

        return ResponseEntity.ok(clienteResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> buscarClientePorId(@PathVariable Long id) {
        Cliente buscarCliente = buscarClientePorIdUsecase.execute(id);
        ClienteResponseDto clienteResponse = clienteMapper.toResponse(buscarCliente);

        return ResponseEntity.ok(clienteResponse);
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDto> criarCliente(@Valid @RequestBody ClienteRequestDto requestDto) {
        var clienteDomain = clienteMapper.toDomain(requestDto);
        var clienteResponse = clienteMapper.toResponse(criarClienteUseCase.execute(clienteDomain));

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteResponse);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> patchCliente(@PathVariable Long id, @RequestBody PatchClienteRequestDto patchDto) {
        Cliente clienteExistente = buscarClientePorIdUsecase.execute(id);
        Cliente clienteAtualizado = clienteMapper.patchToCliente(patchDto, clienteExistente);
        clienteAtualizado = atualizarClienteUsecase.execute(clienteAtualizado);
        ClienteResponseDto responseDto = clienteMapper.toResponse(clienteAtualizado);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarClientePorId(@PathVariable Long id) {
        deletarClientePorId.execute(id);

        return ResponseEntity.noContent().build();
    }

}
