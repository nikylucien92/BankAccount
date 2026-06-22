package com.serviceImpl;

import com.dto.ClienteDto;
import com.entity.Cliente;
import com.mapper.ClienteMapper;
import com.repository.RepositoryCliente;
import com.service.ServiceCliente;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceClienteImpl implements ServiceCliente {

    private RepositoryCliente repositoryCliente;


    @Autowired
    public ServiceClienteImpl(RepositoryCliente repositoryCliente) {
        this.repositoryCliente = repositoryCliente;
    }

    @Override
    @Transactional
    public ClienteDto creaCliente(ClienteDto clienteDto) {
        Cliente cliente = ClienteMapper.mapToCliente(clienteDto);
        Cliente clienteSalvato = repositoryCliente.save(cliente);

        return ClienteMapper.mapToClienteDto(clienteSalvato);
    }

    @Override
    public Optional<ClienteDto> getClienteById(Integer clienteId) {

        Optional<Cliente> clienteOptional = repositoryCliente.findById(clienteId);

        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            ClienteDto clienteDto = new ClienteDto();
            clienteDto.setCodCliente(cliente.getCodCliente());
            clienteDto.setNome(cliente.getNome());
            clienteDto.setCognome(cliente.getCognome());
            clienteDto.setEmail(cliente.getEmail());
            clienteDto.setNumConto(cliente.getNumConto());
            clienteDto.setSaldoContoCorrente(cliente.getSaldoContoCorrente());
            return Optional.of(clienteDto);
        }
        //else ??
        return Optional.empty();
    }

}
