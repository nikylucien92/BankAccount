package com.repository;

import com.entity.Movimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryMovimento  extends JpaRepository<Movimento,Integer> {
/*
        @Query("""
        SELECT m
        FROM Movimento m
        WHERE m.contoCorrente.idConto = :id
        """)
        */
    List<Movimento> findByContoCorrenteIdConto(Integer idConto);

}
