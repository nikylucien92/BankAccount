package com.dto;

import com.entity.CartaCredito;
import com.entity.StatoCarta;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartaCreditoRequestDto {

    private Integer idCarta;
    private String numCarta;
    private String circuito;
    private LocalDate dataScadenza;
    private StatoCarta stato;
    private String pin;

    public CartaCreditoRequestDto(CartaCredito cartaCredito) {
        this.idCarta = cartaCredito.getIdCarta();
        this.numCarta = cartaCredito.getNumCarta();
        this.circuito = cartaCredito.getCircuito();
        this.dataScadenza = cartaCredito.getDataScadenza();
        this.stato = cartaCredito.getStatoCarta();
        this.pin = cartaCredito.getPin();
    }
}
