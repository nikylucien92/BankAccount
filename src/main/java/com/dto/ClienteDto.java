package com.dto;


import com.entity.Cliente;
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
    private int saldoContoCorrente;
    private String numConto;
    private String ruolo;

    public ClienteDto(Cliente cliente) {
    }
}
