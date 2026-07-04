package com.controller;


import com.dto.MovimentoDto;
import com.service.ServiceMovimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movimenti")
public class MovimentoController {

    @Autowired
    private ServiceMovimento serviceMovimento;

    @GetMapping
    public ResponseEntity<List<MovimentoDto>> getAllMovimenti(){

        return ResponseEntity.ok(serviceMovimento.getMovimentiConto());

    }

    @GetMapping("/id")
    public ResponseEntity getMovimentoById(@PathVariable("id") Integer id){

        Optional<MovimentoDto>movimentoDtoOptional=serviceMovimento.getMovimentoById(id);
        if (movimentoDtoOptional.isPresent()) {
            return new ResponseEntity<>(movimentoDtoOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/salvaMovimento")
    public ResponseEntity salvaMovimento(MovimentoDto movimentoDto)
    {
        MovimentoDto movimentoSalvato= serviceMovimento.salvaMovimento(movimentoDto);
        return  new ResponseEntity<>(movimentoSalvato , HttpStatus.CREATED);
    }

}
