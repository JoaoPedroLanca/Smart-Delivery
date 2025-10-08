package com.SmarDelivery.infra.persistence.repositories;

import com.SmarDelivery.infra.persistence.entities.CardapioEntity;
import com.SmarDelivery.infra.persistence.entities.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
}
