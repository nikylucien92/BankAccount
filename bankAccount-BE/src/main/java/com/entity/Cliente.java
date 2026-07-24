package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import jakarta.persistence.Id;
import java.util.Collection;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cliente",schema = "bank")
@Getter
@Setter
public class Cliente implements UserDetails {

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<ContoCorrente> contiCorrenti;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<CartaCredito>carteCredito;

    @Id
    @Column(name = "codCliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codCliente;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "email", unique = true, nullable = false)
    private String email;
   // Così eviti due utenti con la stessa email.

    @Column(name = "ruolo")
    private Ruolo ruolo;

    @Column(name = "password" ,nullable = false)
    private String password;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(ruolo.name()));
        //il return , ritorna un oggetto di un tipo di ruolo , che viene usato nella nostra classe enum di ADMIN,USER per le autorizzazioni
    }

    @Override
    public @Nullable String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
