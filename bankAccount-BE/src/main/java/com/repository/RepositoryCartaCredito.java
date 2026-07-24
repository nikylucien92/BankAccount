package com.repository;

import com.entity.CartaCredito;
import com.entity.StatoCarta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositoryCartaCredito extends JpaRepository<CartaCredito,Integer> {

    // Cerca una carta tramite numero carta
    Optional<CartaCredito> findByNumCarta(String numCarta);


    // Cerca tutte le carte di un cliente
    List<CartaCredito> findByClienteCodCliente(Integer codCliente);


    // Cerca tutte le carte associate ad un conto corrente
    List<CartaCredito> findByContoCorrenteIdConto(Integer idConto);


    // Cerca carte per stato (ATTIVA, BLOCCATA, SCADUTA...)
    List<CartaCredito> findByStatoCarta(StatoCarta statoCarta);



    // Verifica esistenza carta tramite numero
    boolean existsByNumCarta(String numCarta);
}
