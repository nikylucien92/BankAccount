package com.dto;

import com.entity.CartaCredito;
import com.entity.StatoCarta;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartaCreditoDto {

    private Integer idCarta;
    private String numCarta;
    private String circuito;
    private Date dataScadenza;
    private StatoCarta Stato;
    private String password;

    public CartaCreditoDto(CartaCredito cartaCredito) {
    }
}
