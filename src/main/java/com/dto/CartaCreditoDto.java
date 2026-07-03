package com.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartaCreditoDto {

    private Integer numCarta;
    private String circuito;
    private Date dataScadenza;
    private String stato;
    private String tipoCarta;
    private String password;

}
