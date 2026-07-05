package com.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="cartaCredito")
public class CartaCredito {


    @ManyToOne
    @JoinColumn(name="idConto")
    private  ContoCorrente contoCorrente;

    @OneToMany(mappedBy = "cartaCredito")
    private List<Movimento> listaMovimentiCarta;

    @Id
    @Column(name = "idCarta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCarta;

    @Column(name = "numCarta")
    private String numCarta;

    @Column(name = "circuito")
    private String circuito;

    @Column(name = "dataScadenza")
    private Date dataScadenza;


    @Enumerated(EnumType.STRING)
    @Column(name = "tipoCarta")
    private StatoCarta statoCarta;

    // dato sensibile ,cifrare e inserire solo nel db ,e non nel login, poiche serve solo per prelevare questa password
    @Column(name = "password")
    private String password;


}
