package com.controller;


import com.dto.CartaCreditoDto;
import com.dto.ContoCorrenteDto;
import com.service.ServiceCartaCredito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cartaCredito")
public class CartaCreditoController {

    @Autowired
    ServiceCartaCredito serviceCartaCredito;


    @GetMapping
    public ResponseEntity<List<CartaCreditoDto>> getAllCartaCredito(){

        return ResponseEntity.ok(serviceCartaCredito.getListaCartaCredito());
    }


    @GetMapping("/id")
    public ResponseEntity getCartaById(@PathVariable("id") Integer id){

        Optional<CartaCreditoDto> cartaOptionalDto=serviceCartaCredito.getCartaCreditoById(id);
        if (cartaOptionalDto.isPresent()) {
            return new ResponseEntity<>(cartaOptionalDto.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/salvaCartaCredito")
    public ResponseEntity salvaCartaCredito(CartaCreditoDto cartaCreditoDto)
    {
        CartaCreditoDto cartaSalvata=serviceCartaCredito.salvaCartaCredito(cartaCreditoDto);
        return new ResponseEntity<>(cartaSalvata ,HttpStatus.CREATED);
    }


}
