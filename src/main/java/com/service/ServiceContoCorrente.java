package com.service;

import com.dto.ContoCorrenteDto;

import java.util.List;
import java.util.Optional;

public interface ServiceContoCorrente  {

     List<ContoCorrenteDto>getListaContiCorrenti();
     Optional<ContoCorrenteDto> getContoCorrenteById(Integer id);
     ContoCorrenteDto salvaContoCorrente(ContoCorrenteDto contoCorrenteDto);
     void eliminaContoCorrente(Integer id);
       // void modificaStatoConto();
}
