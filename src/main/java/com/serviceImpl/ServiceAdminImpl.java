package com.serviceImpl;

import com.dto.ClienteDto;
import com.dto.ContoCorrenteDto;
import com.dto.MovimentoDto;
import com.entity.Cliente;
import com.repository.RepositoryCliente;
import com.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceAdminImpl implements AdminService {

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

    @Override
    public ContoCorrenteDto creaContoCorrente(Integer id) {
        return null;
    }

    @Override
    public ClienteDto aggiornaCliente(Integer id, ClienteDto dto) {
        return null;
    }

    @Override
    public void disattivaCliente(Integer id) {

    }

    @Override
    public List<MovimentoDto> getMovimentiCliente(Integer idCliente) {
        return List.of();
    }

}
/* CREA CONTO
* trova Cliente

↓

crea ContoCorrente

↓

genera IBAN

↓

saldo = 0

↓

stato = ATTIVO

↓

salva

↓

ritorna DTO*/
