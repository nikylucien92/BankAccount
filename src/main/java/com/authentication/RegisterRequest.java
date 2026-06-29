package com.authentication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    private String nome;
    private String cognome;
    private String email;
    private String password;
    private String numConto;
    private String ruolo;
    private int saldoContoCorrente;
}
