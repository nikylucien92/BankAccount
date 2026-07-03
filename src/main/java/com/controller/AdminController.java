package com.controller;


import com.dto.ClienteDto;
import com.service.ServiceCliente;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @Autowired
    private ServiceCliente serviceCliente;

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> getClienteById(@PathVariable Integer id) {

        return serviceCliente.getClienteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/clienti")
    public ResponseEntity<List<ClienteDto>> getAllClienti(){

        List<ClienteDto>clienti= serviceCliente.getAllClienti();
        return ResponseEntity.ok(clienti);
    }


    @PutMapping("/clienti/{id}")
    public ResponseEntity<ClienteDto> updateCliente(){}


    @DeleteMapping("/clienti/{id}")
    public ResponseEntity<Void> deleteCliente(){}


    @PostMapping("/clienti/{id}/conto")
    public ResponseEntity<?> creaConto(){}


    @PostMapping("/clienti/{id}/carta")
    public ResponseEntity<?> assegnaCarta(){}

    /*
    @GetMapping("/clienti/{id}/movimenti")
    public List<MovimentoDto> getMovimenti(){}
    */


}
