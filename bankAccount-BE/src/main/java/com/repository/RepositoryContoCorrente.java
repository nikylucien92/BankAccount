package com.repository;

import com.entity.ContoCorrente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositoryContoCorrente extends JpaRepository<ContoCorrente,Integer> {

    Optional<ContoCorrente> findByIban(String iban);

    List<ContoCorrente> findByClienteCodCliente(Integer codCliente);
}
