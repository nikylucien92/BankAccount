package com.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="cliente")
public class Cliente {
    @Id
    @Column(name = "codCliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codCliente;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "email")
    private String email;

    @Column(name = "saldoContoCorrente")
    private double saldoContoCorrente;

    @Column(name = "numConto")
    private String numConto;


}
