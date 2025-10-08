package com.SmarDelivery.infra.persistence.repositories;

import com.SmarDelivery.infra.persistence.entities.ClienteEntity;
import com.SmarDelivery.infra.persistence.entities.EntregadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntregadorRepository extends JpaRepository<EntregadorEntity, Long> {
}
