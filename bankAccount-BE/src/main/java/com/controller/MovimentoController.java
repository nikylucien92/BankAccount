package com.controller;


import com.dto.MovimentoDto;
import com.service.ServiceMovimento;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movimenti")
public class MovimentoController {

    private final ServiceMovimento serviceMovimento;

    public MovimentoController(ServiceMovimento serviceMovimento) {
        this.serviceMovimento=serviceMovimento;
    }


    @GetMapping("/conto/id")
    public ResponseEntity<List<MovimentoDto>> getAllMovimenti(@PathVariable("id") Integer id){

        return ResponseEntity.ok(serviceMovimento.getMovimentiConto(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity getMovimentoById(@PathVariable("id") Integer id){

        Optional<MovimentoDto>movimentoDtoOptional=serviceMovimento.getMovimentoById(id);
        if (movimentoDtoOptional.isPresent()) {
            return new ResponseEntity<>(movimentoDtoOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    public ResponseEntity salvaMovimento(@RequestBody MovimentoDto movimentoDto)
    {
        MovimentoDto movimentoSalvato= serviceMovimento.salvaMovimento(movimentoDto);
        return  new ResponseEntity<>(movimentoSalvato , HttpStatus.CREATED);
    }

}
