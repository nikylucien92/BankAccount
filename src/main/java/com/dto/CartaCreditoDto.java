package com.dto;

import com.entity.CartaCredito;
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
    private String stato;
    private String tipoCarta;
    private String password;

    public CartaCreditoDto(CartaCredito cartaCredito) {
    }
}
