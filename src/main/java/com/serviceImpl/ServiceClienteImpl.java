package com.serviceImpl;

import com.dto.ClienteDto;
import com.entity.Cliente;
import com.exception.ResourceNotFoundException;
import com.mapper.ClienteMapper;
import com.repository.RepositoryCliente;
import com.service.ServiceCliente;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public List<ClienteDto> getAllClienti() {
        List<Cliente> clienti =
                repositoryCliente.findAll();

        return clienti.stream()

                .map(ClienteMapper::mapToClienteDto)

                .toList();
    }

    @Override
    public ClienteDto updateCliente(

            Integer codCliente,
            ClienteDto clienteDto){
        Cliente cliente =
                repositoryCliente.findById(codCliente)

                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Cliente non trovato"));

        cliente.setNome(clienteDto.getNome());
        cliente.setCognome(clienteDto.getCognome());
        cliente.setEmail(clienteDto.getEmail());
        cliente.setSaldoContoCorrente(
                clienteDto.getSaldoContoCorrente());
        cliente.setNumConto(
                clienteDto.getNumConto());
        cliente.setRuolo(
                clienteDto.getRuolo());
        Cliente salvato =
                repositoryCliente.save(cliente);

        return ClienteMapper.mapToClienteDto(salvato);
    }

    @Override
    public void deleteCliente(Integer codCliente){

        Cliente cliente =
                repositoryCliente.findById(codCliente)

                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Cliente non trovato"));

        repositoryCliente.delete(cliente);

    }

}
