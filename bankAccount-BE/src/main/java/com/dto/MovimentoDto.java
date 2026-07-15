package com.dto;


import com.entity.Movimento;
import com.entity.TipoMovimento;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovimentoDto {

    private Integer id;

    private LocalDateTime dataMovimento;

    private TipoMovimento tipo;

    private BigDecimal importo;

    private String causale;

    private BigDecimal saldoDopoOperazione;


    //??
    public MovimentoDto(Movimento movimento) {
    }
}
