package com.repository;

import com.entity.CartaCredito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCartaCredito extends JpaRepository<CartaCredito,Integer> {


}
