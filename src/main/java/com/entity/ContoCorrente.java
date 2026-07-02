package com.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="contoCorrente")
public class ContoCorrente{

    @ManyToOne
    @JoinColumn(name="codCliente")
    private Cliente cliente ;

    @Id
    @Column(name = "iban")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iban;

    @Column(name = "saldo")
    private double saldo;

    //ordinario giovani o aziendale
    @Column(name = "tipoConto")
    private String tipoConto;

    //attivo o inattivo
    @Column(name = "stato")
    private String stato;

    @Column(name = "dataApertura")
    private Date dataApertura;

    //euro altro?
    private double valuta;

}
