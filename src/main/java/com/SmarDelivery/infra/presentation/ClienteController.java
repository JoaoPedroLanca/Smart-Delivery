package com.SmarDelivery.infra.presentation;

import com.SmarDelivery.domain.entities.Cliente;
import com.SmarDelivery.domain.usecases.cliente.*;
import com.SmarDelivery.infra.dtos.responses.ClienteResponseDto;
import com.SmarDelivery.infra.mappers.ClienteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
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

}
