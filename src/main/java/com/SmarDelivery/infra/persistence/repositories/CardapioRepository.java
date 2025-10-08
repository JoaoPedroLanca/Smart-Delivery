package com.SmarDelivery.infra.persistence.repositories;

import com.SmarDelivery.infra.persistence.entities.CardapioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardapioRepository extends JpaRepository<CardapioEntity, Long> {
}
