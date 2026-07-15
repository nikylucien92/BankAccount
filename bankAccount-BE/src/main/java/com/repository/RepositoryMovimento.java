package com.repository;

import com.entity.Movimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryMovimento  extends JpaRepository<Movimento,Integer> {

    //trova il conto corrente associato a quel movimento

    List<Movimento> findContoCorrenteById(Integer contoId);

}
