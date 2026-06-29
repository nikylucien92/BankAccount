package com.controller;


import com.dto.ClienteDto;
import com.service.ServiceCliente;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ServiceCliente clienteService;

    @PostMapping("/creaCliente")
    public ResponseEntity<ClienteDto> creaCliente(@RequestBody ClienteDto clienteDTO)
    {

        ClienteDto clienteSalvato= clienteService.creaCliente(clienteDTO);
        return  new ResponseEntity<>(clienteSalvato , HttpStatus.CREATED);

    }


    @GetMapping("/{codCliente}")
    public ResponseEntity<ClienteDto> getClienteById(@PathVariable("codCliente") Integer clienteId) {
        Optional<ClienteDto> clienteDTOOptional = clienteService.getClienteById(clienteId);
    System.out.println("entrato nel controller : " + clienteId);
        if (clienteDTOOptional.isPresent()) {
            return new ResponseEntity<>(clienteDTOOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<ClienteDto>> getAllClienti(){

        List<ClienteDto> clienti = clienteService.getAllClienti();

        return ResponseEntity.ok(clienti);

    }


}
