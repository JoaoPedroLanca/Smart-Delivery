package com.SmarDelivery.infra.persistence.entities;

import com.SmarDelivery.domain.enums.MeioDeTransporte;
import com.SmarDelivery.domain.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Locale;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "entregador_tb")
public class EntregadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long entregadorId;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(name = "meio_de_transporte", nullable = false)
    private MeioDeTransporte meioDeTransporte;

    @Column(nullable = false)
    private boolean disponivel;

    @Column(name = "localizacao_atual", nullable = false)
    private String localizacaoAtual; // latitude,longitude ou VO

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @OneToMany(mappedBy = "entregador")
    private List<PedidoEntity> pedidos;
}
