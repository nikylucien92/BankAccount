package com.repository;

import com.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryCliente extends JpaRepository <Cliente,Integer>{
    Optional<Cliente> findByUsername(String username);

    Optional<Cliente> findByEmail(String email);
}
