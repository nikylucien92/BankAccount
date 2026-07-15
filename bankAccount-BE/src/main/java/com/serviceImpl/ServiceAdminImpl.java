package com.serviceImpl;

import com.dto.ClienteDto;
import com.dto.ContoCorrenteDto;
import com.dto.MovimentoDto;
import com.entity.Cliente;
import com.repository.RepositoryCliente;
import com.service.AdminService;
import com.service.ServiceCartaCredito;
import com.service.ServiceContoCorrente;
import com.service.ServiceMovimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceAdminImpl implements AdminService {

    @Autowired
    RepositoryCliente  repositoryCliente;

    @Autowired
    private ServiceContoCorrente contoCorrenteService;

    @Autowired
    private ServiceCartaCredito cartaCreditoService;

    @Autowired
    private ServiceMovimento movimentoService;

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
    public ClienteDto aggiornaCliente(Integer id, ClienteDto dto) {

        Cliente cliente = repositoryCliente.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Cliente non trovato"));
     cliente.setNome(dto.getNome());
     cliente.setCognome(dto.getCognome());
     cliente.setEmail(dto.getEmail());
     cliente.setSaldoContoCorrente(dto.getSaldoContoCorrente());
     cliente.setNumConto(dto.getNumConto());
     cliente.setRuolo(dto.getRuolo());
     Cliente clienteAggiornato=repositoryCliente.save(cliente);

        return new ClienteDto(clienteAggiornato);
    }

    @Override
    public void disattivaCliente(Integer id) {

    }

    @Override
    public ContoCorrenteDto creaContoCorrente(ContoCorrenteDto contoCorrenteDto) {
        return contoCorrenteService.salvaContoCorrente(contoCorrenteDto);
    }



}

