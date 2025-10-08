package com.SmarDelivery.infra.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "item_pedido_tb")
public class ItemPedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @Column(nullable = false)
    private int quantidade;

    @Column(name = "preco_unitario", nullable = false)
    private double precoUnitario;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private PedidoEntity pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private CardapioEntity produto;
}
