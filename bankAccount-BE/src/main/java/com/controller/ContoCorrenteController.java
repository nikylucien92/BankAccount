package com.controller;


import com.dto.ContoCorrenteDto;
import com.service.ServiceContoCorrente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contoCorrente")
public class ContoCorrenteController {


   private final  ServiceContoCorrente serviceContoCorrente;

    public ContoCorrenteController(ServiceContoCorrente serviceContoCorrente) {
        this.serviceContoCorrente = serviceContoCorrente;
    }

    @GetMapping
    public ResponseEntity<List<ContoCorrenteDto>>getAllContoCorrente(){

        return ResponseEntity.ok(serviceContoCorrente.getListaContiCorrenti());

    }

@GetMapping("/id")
public ResponseEntity getContoCorrenteById(@PathVariable("id") Integer id){

        Optional<ContoCorrenteDto> contoOptionalDto=serviceContoCorrente.getContoCorrenteById(id);
    if (contoOptionalDto.isPresent()) {
        return new ResponseEntity<>(contoOptionalDto.get(), HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

    @PostMapping("/salvaContoCorrente")
    public ResponseEntity salvaContoCorrente(ContoCorrenteDto contoCorrenteDto)
    {
      ContoCorrenteDto contoSalvato=serviceContoCorrente.salvaContoCorrente(contoCorrenteDto);
              return new ResponseEntity<>(contoSalvato ,HttpStatus.CREATED);
    }

}
