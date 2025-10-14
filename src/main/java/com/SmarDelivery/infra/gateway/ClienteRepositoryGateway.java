package com.SmarDelivery.infra.gateway;

import com.SmarDelivery.domain.entities.Cliente;
import com.SmarDelivery.domain.gateway.ClienteGateway;
import com.SmarDelivery.infra.mappers.ClienteMapper;
import com.SmarDelivery.infra.persistence.entities.ClienteEntity;
import com.SmarDelivery.infra.persistence.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
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
}
