package com.service;

import com.dto.MovimentoDto;

import java.util.List;
import java.util.Optional;

public interface ServiceMovimento {

    List<MovimentoDto> getMovimentiConto();

    Optional<MovimentoDto> getMovimentoById(Integer id);

    MovimentoDto salvaMovimento(MovimentoDto movimentoDto);
}
