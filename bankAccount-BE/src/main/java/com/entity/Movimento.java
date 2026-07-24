package com.entity;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "movimento" ,schema = "bank")
public class Movimento {


    @ManyToOne
    @JoinColumn(name = "idConto")
    private ContoCorrente contoCorrente;

    @ManyToOne
    @JoinColumn(name="idCarta")
    private CartaCredito cartaCredito;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="dataMovimento")
    private LocalDateTime dataMovimento;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private TipoMovimento tipo;

    @Column(name = "importo")
    private BigDecimal importo;

    @Column(name = "causale")
    private String causale;

    @Column(name = "saldoDopoOperazione")
    private BigDecimal saldoDopoOperazione;


}
