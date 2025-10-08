package com.SmarDelivery.infra.persistence.repositories;

import com.SmarDelivery.infra.persistence.entities.CardapioEntity;
import com.SmarDelivery.infra.persistence.entities.ItemPedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedidoEntity, Long> {
}
