package com.serviceImpl;


import com.dto.MovimentoDto;
import com.entity.Movimento;
import com.repository.RepositoryMovimento;
import com.service.ServiceMovimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceMovimentoImpl implements ServiceMovimento {

    @Autowired
    RepositoryMovimento repoMovimento;


    @Override
    public List<MovimentoDto> getMovimentiConto() {
        List<Movimento>movimenti=repoMovimento.findAll();
        List<MovimentoDto> listaDto = new ArrayList<>();

        for (Movimento movimento : movimenti) {

            MovimentoDto dto = new MovimentoDto();

            dto.setId(movimento.getId());
            dto.setDataMovimento(movimento.getDataMovimento());
            dto.setTipo(movimento.getTipo());
            dto.setImporto(movimento.getImporto());
            dto.setCausale(movimento.getCausale());
            dto.setSaldoDopoOperazione(movimento.getSaldoDopoOperazione());

            listaDto.add(dto);
        }

        return listaDto;
    }


    @Override
    public Optional<MovimentoDto> getMovimentoById(Integer id) {
        return repoMovimento.findById(id).map(MovimentoDto :: new);
    }


    @Override
    public MovimentoDto salvaMovimento(MovimentoDto movimentoDto) {
       Movimento movimento =new Movimento();
        movimento.setDataMovimento(movimentoDto.getDataMovimento());
        movimento.setTipo(movimentoDto.getTipo());
        movimento.setImporto(movimentoDto.getImporto());
        movimento.setCausale(movimentoDto.getCausale());
        movimento.setSaldoDopoOperazione(movimentoDto.getSaldoDopoOperazione());

         Movimento movimentoSalvato= repoMovimento.save(movimento);

        return new MovimentoDto( movimentoSalvato);
    }
}
