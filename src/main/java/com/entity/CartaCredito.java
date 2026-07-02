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
@Table(name="cartaCredito")
public class CartaCredito {


    @ManyToOne
    @JoinColumn(name="codCliente")
    private  Cliente cliente;

    @Id
    @Column(name = "numCarta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numCarta;

    @Column(name = "circuito")
    private String circuito;

    @Column(name = "dataScadenza")
    private Date dataScadenza;

    //attiva ,bloccata ,scaduta
    @Column(name = "stato")
    private String stato;

    //addebito o credito o prepagata
    @Column(name = "tipoCarta")
    private String tipoCarta;

    // dato sensibile ,cifrare e inserire solo nel db ,e non nel login, poiche serve solo per prelevare questa password
    @Column(name = "password")
    private String password;


}
