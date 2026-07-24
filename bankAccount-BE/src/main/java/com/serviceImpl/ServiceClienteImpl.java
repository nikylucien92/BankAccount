package com.serviceImpl;

import com.dto.ClienteDto;
import com.entity.Cliente;
import com.exception.ResourceAlreadyExistsException;
import com.exception.ResourceNotFoundException;
import com.mapper.ClienteMapper;
import com.repository.RepositoryCliente;
import com.service.ServiceCliente;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


//Si definisce al capo della classe, perche ogni operazione che si farà
//in questo Service ,rispettano tutte le proprietà ACID

@Service
@Transactional
public class ServiceClienteImpl implements ServiceCliente {

    private final RepositoryCliente repositoryCliente;
    private final PasswordEncoder passwordEncoder;

    public ServiceClienteImpl(RepositoryCliente repositoryCliente ,PasswordEncoder passwordEncoder) {

        this.passwordEncoder=passwordEncoder;
        this.repositoryCliente = repositoryCliente;
    }


    @Override
    public List<ClienteDto> findAll() {
        return repositoryCliente.findAll()
                .stream()
                .map(ClienteMapper::mapToClienteDto)
                .toList();    }

    @Override
    public ClienteDto findById(Integer id) {

        Cliente cliente = repositoryCliente.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Cliente non trovato"));

        return ClienteMapper.mapToClienteDto(cliente);
    }

    @Override
    public ClienteDto save(ClienteDto dto) {

        Cliente cliente = ClienteMapper.mapToCliente(dto);
        cliente.setPassword(passwordEncoder.encode(dto.getPassword()));
        Cliente salvato = repositoryCliente.save(cliente);

        return ClienteMapper.mapToClienteDto(salvato);
    }

    @Override
    public ClienteDto update(Integer id, ClienteDto dto) {

        Cliente cliente = repositoryCliente.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Cliente non trovato"));

        cliente.setNome(dto.getNome());
        cliente.setCognome(dto.getCognome());
        cliente.setEmail(dto.getEmail());
        cliente.setRuolo(dto.getRuolo());

        if(dto.getPassword()!=null){
            passwordEncoder.encode(dto.getPassword());
        }

        if(repositoryCliente.existsByEmail(dto.getEmail())){
            throw new ResourceAlreadyExistsException(
                    "Email già presente"
            );
        }

        Cliente aggiornato = repositoryCliente.save(cliente);

        return ClienteMapper.mapToClienteDto(aggiornato);
    }

    @Override
    public void delete(Integer id) {

        Cliente cliente = repositoryCliente.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Cliente non trovato"));

        repositoryCliente.delete(cliente);

    }

    @Override
    public ClienteDto findByEmail(String email) {

        Cliente cliente = repositoryCliente.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Cliente non trovato"));

        return ClienteMapper.mapToClienteDto(cliente);
    }
}
