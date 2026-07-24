package com.dto;


import com.entity.Ruolo;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClienteDto {
    private Integer codCliente;
    private String nome;
    private String cognome;
    private String email;
    private Ruolo ruolo;
    private String password;


}
