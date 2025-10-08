package com.SmarDelivery.infra.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "restaurante_tb")
public class RestauranteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restauranteId;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cnpj;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private boolean aberto;

    @Column(name = "horario_abertura", nullable = false)
    private LocalDateTime horarioAbertura;

    @Column(name = "horario_fechamento", nullable = false)
    private LocalDateTime horarioFechamento;

    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL)
    private List<CardapioEntity> cardapio;

    @OneToMany(mappedBy = "restaurante")
    private List<PedidoEntity> pedidos;
}
