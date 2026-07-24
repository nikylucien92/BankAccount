package com.serviceImpl;

import com.dto.ContoCorrenteDto;
import com.dto.MovimentoDto;
import com.entity.ContoCorrente;
import com.entity.Movimento;
import com.mapper.ContoCorrenteMapper;
import com.mapper.MovimentoMapper;
import com.repository.RepositoryContoCorrente;
import com.repository.RepositoryMovimento;
import com.service.ServiceContoCorrente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceContoCorrenteImpl implements ServiceContoCorrente {
    private final RepositoryContoCorrente repositoryContoCorrente;
        private final RepositoryMovimento repositoryMovimento;

    public ServiceContoCorrenteImpl(RepositoryContoCorrente repositoryContoCorrente ,RepositoryMovimento repositoryMovimento) {
        this.repositoryContoCorrente = repositoryContoCorrente;
        this.repositoryMovimento=repositoryMovimento;
    }

    @Override
    public List<ContoCorrenteDto> getListaContiCorrenti() {

        return repositoryContoCorrente.findAll()
                .stream()
                .map(ContoCorrenteMapper::mapToContoCorrenteDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ContoCorrenteDto> getContoCorrenteById(Integer id) {

        return repositoryContoCorrente.findById(id)
                .map(ContoCorrenteMapper::mapToContoCorrenteDto);
    }

    @Override
    public ContoCorrenteDto salvaContoCorrente(ContoCorrenteDto contoCorrenteDto) {

        ContoCorrente contoCorrente = ContoCorrenteMapper.mapToContoCorrente(contoCorrenteDto);

        // Valori di default
        contoCorrente.setSaldo(BigDecimal.ZERO);
        contoCorrente.setDataApertura(LocalDate.now());

        ContoCorrente salvato = repositoryContoCorrente.save(contoCorrente);

        return ContoCorrenteMapper.mapToContoCorrenteDto(salvato);
    }

    @Override
    public ContoCorrenteDto aggiornaConto(Integer id, ContoCorrenteDto dto) {
        return null;
    }

    @Override
    public void eliminaContoCorrente(Integer id) {

        if (!repositoryContoCorrente.existsById(id)) {
            throw new RuntimeException("Conto corrente non trovato con id: " + id);
        }

        repositoryContoCorrente.deleteById(id);
    }
/*
    @Override
    public ContoCorrenteDto deposita(Integer idConto, double importo) {
        return null;
    }

    @Override
    public ContoCorrenteDto preleva(Integer idConto, double importo) {
        return null;
    }

    @Override
    public void bonifico(Integer contoMittente, Integer contoDestinatario, double importo) {

    }
*/

}
