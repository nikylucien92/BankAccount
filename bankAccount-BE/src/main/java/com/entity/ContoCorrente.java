package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="contoCorrente",schema = "bank")
public class ContoCorrente{

    //Con le relazioni bidirezionali (Cliente -> ContoCorrente -> Cliente) rischi un loop infinito quando restituisci JSON

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="codCliente")
    private Cliente cliente ;

    @OneToMany(mappedBy = "contoCorrente" ,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Movimento> listaMovimentiConto;

    @Id
    @Column(name="idConto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer idConto;

    @Column(unique=true ,name="iban",nullable = false)
    private String iban;

    @Column(name="numConto" ,unique = true)
    private String numConto;

    //double perde di precisione
    @Column(name = "saldo")
    private BigDecimal saldo;

    @Column(name = "tipoConto")
    private TipoConto tipoConto;

    //attivo o inattivo
    @Enumerated(EnumType.STRING)
    @Column(name = "stato")
    private StatoConto stato;

    @Column(name = "dataApertura")
    private LocalDate dataApertura;

    @Column(name = "valuta")
    private String valuta;

}
