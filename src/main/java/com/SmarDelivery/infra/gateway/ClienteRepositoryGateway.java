package com.SmarDelivery.infra.gateway;

import com.SmarDelivery.domain.entities.Cliente;
import com.SmarDelivery.domain.gateway.ClienteGateway;
import com.SmarDelivery.infra.dtos.requests.cliente.PatchClienteRequestDto;
import com.SmarDelivery.infra.mappers.ClienteMapper;
import com.SmarDelivery.infra.persistence.entities.ClienteEntity;
import com.SmarDelivery.infra.persistence.repositories.ClienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class ClienteRepositoryGateway implements ClienteGateway {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    @Override
    public Optional<Cliente> buscarClientePorId(Long clienteId) {
        Optional<ClienteEntity> cliente = clienteRepository.findById(clienteId);
        return cliente.map(clienteMapper::toDomain);
    }

    @Override
    public Cliente criarCliente(Cliente cliente) {
        ClienteEntity clienteEntity = clienteMapper.toEntity(cliente);
        ClienteEntity novoCliente = clienteRepository.save(clienteEntity);
        return clienteMapper.toDomain(novoCliente);
    }

    @Override
    public List<Cliente> buscarTodosOsClientes() {
        List<ClienteEntity> clientes = clienteRepository.findAll();
        return clientes
                .stream()
                .map(clienteMapper::toDomain)
                .toList();
    }

    @Transactional
    @Override
    public Cliente atualizarCliente(Long clienteId, Map<String, Object> atualizacao) {
        ClienteEntity clienteEntity = clienteRepository.findById(clienteId).orElseThrow(() -> new RuntimeException("Cliente" + clienteId + " não encontrado em sistema para atualização"));
        Cliente clienteDomain = clienteMapper.toDomain(clienteEntity);
        ObjectMapper objectMapper = new ObjectMapper();
        PatchClienteRequestDto patchDto = objectMapper.convertValue(atualizacao, PatchClienteRequestDto.class);
        Cliente clienteAtualizado = merge(patchDto, clienteDomain);
        ClienteEntity clienteAtualizadoEntity = clienteMapper.toEntity(clienteAtualizado);
        ClienteEntity novoCliente = clienteRepository.save(clienteAtualizadoEntity);

        return clienteMapper.toDomain(novoCliente);
    }

    private Cliente merge(PatchClienteRequestDto patchDto, Cliente cliente) {
        return clienteMapper.patchToCliente(patchDto, cliente);
    }

    @Override
    public void deletarClientePorId(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }
}
