package com.service;

import com.dto.MovimentoDto;
import com.entity.Movimento;

import java.util.List;
import java.util.Optional;

public interface ServiceMovimento {

    List<MovimentoDto> getMovimentiConto(Integer contoId);

    Optional<MovimentoDto> getMovimentoById(Integer id);

    MovimentoDto salvaMovimento(MovimentoDto movimentoDto);
}
