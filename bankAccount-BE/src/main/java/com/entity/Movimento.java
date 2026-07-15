package com.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "movimento")
public class Movimento {

    @ManyToOne
    @JoinColumn(name = "iban")
    private ContoCorrente contoCorrente;

    @ManyToOne
    @JoinColumn(name="numCarta")
    private CartaCredito cartaCredito;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime dataMovimento;

    @Enumerated(EnumType.STRING)
    private TipoMovimento tipo;

    private BigDecimal importo;

    private String causale;

    private BigDecimal saldoDopoOperazione;


}
