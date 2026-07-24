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

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    private final ServiceCliente serviceCliente;
    public ClienteController(ServiceCliente serviceCliente) {
        this.serviceCliente = serviceCliente; }

    /** * Restituisce tutti i clienti. * * GET /cliente */
    @GetMapping
    public ResponseEntity<List<ClienteDto>> findAll() {
        return ResponseEntity.ok( serviceCliente.findAll() ); }



    /** * Restituisce un cliente tramite id. * * GET /cliente/{id} */
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> findById( @PathVariable Integer id) {

        return ResponseEntity.ok( serviceCliente.findById(id) );

    }


    /** * Restituisce un cliente tramite email. * * GET /cliente/email/{email} */
    @GetMapping("/email/{email}") public ResponseEntity<ClienteDto> findByEmail( @PathVariable String email)
    {
        return ResponseEntity.ok( serviceCliente.findByEmail(email) );
     }


    /** * Inserisce un nuovo cliente. * * POST /cliente */
    @PostMapping public ResponseEntity<ClienteDto> save(  @RequestBody ClienteDto clienteDto)

    {
        ClienteDto clienteSalvato = serviceCliente.save(clienteDto); return new ResponseEntity<>( clienteSalvato, HttpStatus.CREATED );
    }


    /** * Aggiorna un cliente. * * PUT /cliente/{id} */
    @PutMapping("/{id}") public ResponseEntity<ClienteDto> update( @PathVariable Integer id, @RequestBody ClienteDto clienteDto)

    {
        return ResponseEntity.ok( serviceCliente.update(id, clienteDto) );

    }

    /** * Elimina un cliente. * * DELETE /cliente/{id} */
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete( @PathVariable Integer id)

    {
        serviceCliente.delete(id); return ResponseEntity.noContent().build();

    }


}
