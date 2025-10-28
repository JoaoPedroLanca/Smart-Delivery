package com.SmarDelivery.infra.gateway;

import com.SmarDelivery.domain.entities.Entregador;
import com.SmarDelivery.domain.gateway.EntregadorGateway;
import com.SmarDelivery.infra.dtos.requests.entregador.PatchEntregadorRequestDto;
import com.SmarDelivery.infra.mappers.EntregadorMapper;
import com.SmarDelivery.infra.persistence.entities.EntregadorEntity;
import com.SmarDelivery.infra.persistence.repositories.EntregadorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class EntregadorRepositoryGateway implements EntregadorGateway {

    private final EntregadorRepository entregadorRepository;
    private final EntregadorMapper entregadorMapper;

    @Override
    public Entregador criarEntregador(Entregador entregador) {
        var entregadorEntity = entregadorMapper.toEntity(entregador);
        var novoEntregador = entregadorRepository.save(entregadorEntity);
        return entregadorMapper.toDomain(novoEntregador);
    }

    @Override
    public Optional<Entregador> buscarEntregadorPorId(Long entregadorId) {
        var entregador = entregadorRepository.findById(entregadorId);
        return entregador.map(entregadorMapper::toDomain);
    }

    @Override
    public List<Entregador> buscarTodosEntregadores() {
        return entregadorRepository.findAll()
                .stream()
                .map(entregadorMapper::toDomain)
                .toList();
    }

    @Override
    public Entregador atualizarEntregador(Long entregadorId, Map<String, Object> atualizacao) {
        EntregadorEntity entregadorEntity = entregadorRepository.findById(entregadorId).orElseThrow(() -> new RuntimeException("Entregador não encontrado em sistema para atualização"));
        Entregador entregadorDomain = entregadorMapper.toDomain(entregadorEntity);
        ObjectMapper objectMapper = new ObjectMapper();
        var patchDto = objectMapper.convertValue(atualizacao, PatchEntregadorRequestDto.class);
        Entregador entregadorAtualizado = merge(patchDto, entregadorDomain);
        EntregadorEntity entregadorAtualizadoEntity = entregadorMapper.toEntity(entregadorAtualizado);
        EntregadorEntity novoEntregador = entregadorRepository.save(entregadorAtualizadoEntity);

        return entregadorMapper.toDomain(novoEntregador);
    }

    private Entregador merge(PatchEntregadorRequestDto patchDto, Entregador entregador) {
        return entregadorMapper.patchToEntregador(patchDto, entregador);
    }
}
