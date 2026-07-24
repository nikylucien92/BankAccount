package com.service;

import com.dto.ContoCorrenteDto;
import com.dto.MovimentoDto;

import java.util.List;
import java.util.Optional;

public interface ServiceContoCorrente  {

     List<ContoCorrenteDto> getListaContiCorrenti();

     Optional<ContoCorrenteDto> getContoCorrenteById(Integer id);

     ContoCorrenteDto salvaContoCorrente(ContoCorrenteDto dto);

     ContoCorrenteDto aggiornaConto(Integer id, ContoCorrenteDto dto);

     void eliminaContoCorrente(Integer id);

     //Funzionalita prettamente Bancarie

    // ContoCorrenteDto deposita(Integer idConto, double importo);

     //ContoCorrenteDto preleva(Integer idConto, double importo);

     //void bonifico(Integer contoMittente, Integer contoDestinatario,double importo);

}
