package com.serviceImpl;

import com.dto.ContoCorrenteDto;
import com.entity.ContoCorrente;
import com.repository.RepositoryContoCorrente;
import com.service.ServiceContoCorrente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceContoCorrenteImpl implements ServiceContoCorrente {

    @Autowired
    RepositoryContoCorrente repositoryContoCorrente;

    @Override
    public List<ContoCorrenteDto> getListaContiCorrenti() {

        return repositoryContoCorrente.findAll()
                .stream()
                .map(ContoCorrenteDto::new)
                .toList();
    }

    @Override
    public Optional<ContoCorrenteDto> getContoCorrenteById(Integer id) {

        return repositoryContoCorrente.findById(id)
                .map(ContoCorrenteDto::new);
    }

    @Override
    public ContoCorrenteDto salvaContoCorrente(ContoCorrenteDto contoCorrenteDto) {

        ContoCorrente conto=new ContoCorrente();
        conto.setIban(contoCorrenteDto.getIban());
        conto.setSaldo(contoCorrenteDto.getSaldo());

        ContoCorrente contoSalvato = repositoryContoCorrente.save(conto);

        return new ContoCorrenteDto(contoSalvato);
    }

    @Override
    public void eliminaContoCorrente(Integer id) {

        ContoCorrente conto = repositoryContoCorrente.findById(id)
                .orElseThrow(() -> new RuntimeException("Conto corrente non trovato"));

        repositoryContoCorrente.delete(conto);
    }
}
