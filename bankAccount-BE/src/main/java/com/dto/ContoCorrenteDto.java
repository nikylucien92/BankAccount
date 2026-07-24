package com.dto;

import com.entity.StatoConto;
import com.entity.TipoConto;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContoCorrenteDto {

    private Integer idConto;
    private String iban;
    private BigDecimal saldo;
    private TipoConto tipoConto;
    private StatoConto stato;
    private LocalDate dataApertura;
    private String valuta;

}
