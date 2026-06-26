package com.entity;

import jakarta.persistence.*;
import lombok.*;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="cliente")
public class Cliente implements UserDetails {


    public Cliente(Integer codCliente, String nome, String cognome, String email, double saldoContoCorrente, String numConto, String ruolo) {
    }

    @Id
    @Column(name = "codCliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codCliente;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "email")
    private String email;

    @Column(name = "saldoContoCorrente")
    private double saldoContoCorrente;

    @Column(name = "numConto")
    private String numConto;

    @Column(name = "ruolo")
    private String ruolo;

    @Column(name = "password")
    private String password;




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public @Nullable String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }
}
