package com.controller;


import com.dto.CartaCreditoRequestDto;
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
    public ResponseEntity<List<CartaCreditoRequestDto>> getAllCartaCredito(){

        return ResponseEntity.ok(serviceCartaCredito.getListaCartaCredito());
    }


    @GetMapping("/{id}")
    public ResponseEntity getCartaById(@PathVariable("id") Integer id){

        Optional<CartaCreditoRequestDto> cartaOptionalDto=serviceCartaCredito.getCartaCreditoById(id);
        if (cartaOptionalDto.isPresent()) {
            return new ResponseEntity<>(cartaOptionalDto.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity salvaCartaCredito(@RequestBody CartaCreditoRequestDto cartaCreditoRequestDto)
    {
        CartaCreditoRequestDto cartaSalvata=serviceCartaCredito.salvaCartaCredito(cartaCreditoRequestDto);
        return new ResponseEntity<>(cartaSalvata ,HttpStatus.CREATED);
    }


}
