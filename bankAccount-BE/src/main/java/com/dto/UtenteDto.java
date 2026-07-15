package com.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UtenteDto {


    private Integer idUtente;
    private String nome;
    private String email;
    private String password;
    private String ruolo;

}
