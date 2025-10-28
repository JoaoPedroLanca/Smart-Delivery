package com.SmarDelivery.infra.gateway;

import com.SmarDelivery.domain.entities.Entregador;
import com.SmarDelivery.domain.gateway.EntregadorGateway;
import com.SmarDelivery.infra.mappers.EntregadorMapper;
import com.SmarDelivery.infra.persistence.repositories.EntregadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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
}
