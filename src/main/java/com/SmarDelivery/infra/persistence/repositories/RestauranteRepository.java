package com.SmarDelivery.infra.persistence.repositories;

import com.SmarDelivery.infra.persistence.entities.CardapioEntity;
import com.SmarDelivery.infra.persistence.entities.RestauranteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<RestauranteEntity, Long> {
}
