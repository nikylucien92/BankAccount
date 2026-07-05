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
@Table(name="contoCorrente")
public class ContoCorrente{

    @ManyToOne
    @JoinColumn(name="codCliente")
    private Cliente cliente ;

    @OneToMany(mappedBy = "contoCorrente")
    private List<Movimento> listaMovimentiConto;

    @Id
    @Column(name="idConto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer idConto;

    @Column(unique=true ,name="iban")
    private String iban;

    @Column(name = "saldo")
    private double saldo;

    //ordinario giovani o aziendale
    @Column(name = "tipoConto")
    private String tipoConto;

    //attivo o inattivo
    @Enumerated(EnumType.STRING)
    @Column(name = "stato")
    private StatoConto stato;

    @Column(name = "dataApertura")
    private Date dataApertura;

    @Column(name = "valuta")
    private String valuta;

}
