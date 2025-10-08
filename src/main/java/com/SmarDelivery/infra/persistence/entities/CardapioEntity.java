package com.SmarDelivery.infra.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "cardapio_tb")
public class CardapioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long produtoId;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private double preco;

    @Column(nullable = false)
    private boolean disponivel;

    @ManyToOne
    @JoinColumn(name = "restaurante_id", nullable = false)
    private RestauranteEntity restaurante;
}
