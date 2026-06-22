package com.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClienteDto {
    private Integer codCliente;
    private String nome;
    private String cognome;
    private String email;
    private double saldoContoCorrente;
    private String numConto;


}
