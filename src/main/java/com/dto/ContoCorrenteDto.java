package com.dto;

import com.entity.Cliente;
import com.entity.ContoCorrente;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContoCorrenteDto {

    private Integer idConto;
    private String iban;
    private double saldo;
    private String tipoConto;
    private String stato;
    private Date dataApertura;
    private double valuta;

    public ContoCorrenteDto(ContoCorrente contoCorrente) {
    }
}
