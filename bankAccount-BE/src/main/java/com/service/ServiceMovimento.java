package com.service;

import com.dto.MovimentoDto;

import java.util.List;
import java.util.Optional;

public interface ServiceMovimento {

    List<MovimentoDto> getListaMovimenti();

    Optional<MovimentoDto> getMovimentoById(Integer id);

    List<MovimentoDto> getMovimentiConto(Integer idConto);

    MovimentoDto salvaMovimento(MovimentoDto movimentoDto);

    void eliminaMovimento(Integer id);

}
