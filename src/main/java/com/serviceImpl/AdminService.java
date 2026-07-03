package com.serviceImpl;

import com.dto.ClienteDto;
import com.entity.Cliente;
import com.repository.RepositoryCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    RepositoryCliente  repositoryCliente;

    public List<ClienteDto> getAllClienti(){

        List<Cliente> clienti = repositoryCliente.findAll();

        return clienti.stream()
                .map(ClienteDto::new) // oppure il tuo mapper
                .toList();
    }


    public Optional<ClienteDto> getClienteById(Integer idCliente) {

        return repositoryCliente.findById(idCliente)
                .map(ClienteDto::new);
    }

    public void creaConto(){}

    public void assegnaCarta(){}


public Optional<CartaCredito>
}
