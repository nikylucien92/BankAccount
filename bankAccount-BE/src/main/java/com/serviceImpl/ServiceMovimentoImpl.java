package com.serviceImpl;


import com.dto.MovimentoDto;
import com.entity.Movimento;
import com.mapper.MovimentoMapper;
import com.repository.RepositoryMovimento;
import com.service.ServiceMovimento;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceMovimentoImpl implements ServiceMovimento {

    private final RepositoryMovimento repositoryMovimento;

    public ServiceMovimentoImpl(RepositoryMovimento repositoryMovimento) {
        this.repositoryMovimento = repositoryMovimento;
    }

    @Override
    public List<MovimentoDto> getListaMovimenti() {

        return repositoryMovimento.findAll()
                .stream()
                .map(MovimentoMapper::mapToMovimentoDto)
                .collect(Collectors.toList());

    }

    @Override
    public Optional<MovimentoDto> getMovimentoById(Integer id) {

        return repositoryMovimento.findById(id)
                .map(MovimentoMapper::mapToMovimentoDto);

    }

    @Override
    public List<MovimentoDto> getMovimentiConto(Integer idConto) {

        return repositoryMovimento.findByContoCorrenteIdConto(idConto)
                .stream()
                .map(MovimentoMapper::mapToMovimentoDto)
                .collect(Collectors.toList());

    }

    @Override
    public MovimentoDto salvaMovimento(MovimentoDto movimentoDto) {

        Movimento movimento = MovimentoMapper.mapToMovimento(movimentoDto);

        movimento.setDataMovimento(LocalDateTime.now());

        Movimento salvato = repositoryMovimento.save(movimento);

        return MovimentoMapper.mapToMovimentoDto(salvato);

    }

    @Override
    public void eliminaMovimento(Integer id) {

        if(!repositoryMovimento.existsById(id)){
            throw new RuntimeException("Movimento non trovato");
        }

        repositoryMovimento.deleteById(id);

    }

}