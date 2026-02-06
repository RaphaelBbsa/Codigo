package br.com.barberporto.barberporto.domain;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "servicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome; // Ex: "Corte Degradê"

    @Column(nullable = false)
    private BigDecimal preco; // Ex: 50.00

    @Column(nullable = false)
    private Integer duracaoMinutos; // Ex: 30, 45, 60
}