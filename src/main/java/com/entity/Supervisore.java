package com.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="supervisore")
public class Supervisore {
    @Id
    @Column(name = "matricola")
    private Integer matricola;

    @Column(name = "nome")
    private String nomeUtente;

}
