package com.SmarDelivery.infra.persistence.entities;

import com.SmarDelivery.domain.enums.FormaDePagamento;
import com.SmarDelivery.domain.enums.StatusDoPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "pedido_tb")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pedidoId;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "restaurante_id", nullable = false)
    private RestauranteEntity restaurante;

    @ManyToOne
    @JoinColumn(name = "entregador_id", nullable = false)
    private EntregadorEntity entregador;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedidoEntity> itens;

    @Column(name = "total_do_pedido",nullable = false)
    private double totalDoPedido;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_pedido", nullable = false)
    private StatusDoPedido statusPedido;

    @Column(name = "ciracao_do_pedido", nullable = false)
    private LocalDateTime criacaoDoPedido;

    @Column(name = "endereco_cliente", nullable = false)
    private String enderecoCliente;

    @Column(nullable = false)
    private String distancia;

    @Enumerated(EnumType.STRING)
    @Column(name = "forma_de_pagamento", nullable = false)
    private FormaDePagamento formaDePagamento;

    @Column(name = "tempo_estimado_de_entrega", nullable = false)
    private Long tempoEstimadoDeEntrega;
}
