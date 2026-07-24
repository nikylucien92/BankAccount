package com.entity;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name="cartaCredito",schema = "bank")
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

    @Column(name = "numCarta" ,unique = true)
    private String numCarta;

    @Column(name = "circuito")
    private String circuito;

    @Column(name = "dataScadenza")
    private LocalDate dataScadenza;


    @Enumerated(EnumType.STRING)
    @Column(name = "statoCarta")
    private StatoCarta statoCarta;

    // dato sensibile ,cifrare e inserire solo nel db ,e non nel login, poiche serve solo per prelevare questa password
    @Column(name = "pin")
    private String pin;

    @ManyToOne
    @JoinColumn(name = "codCliente")
    private Cliente cliente;

}
