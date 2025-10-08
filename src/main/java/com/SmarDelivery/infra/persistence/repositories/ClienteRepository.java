package com.SmarDelivery.infra.persistence.repositories;

import com.SmarDelivery.infra.persistence.entities.CardapioEntity;
import com.SmarDelivery.infra.persistence.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
}
