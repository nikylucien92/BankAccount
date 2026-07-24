package com.mapper;

import com.dto.ClienteDto;
import com.entity.Cliente;

public class ClienteMapper {

    public static ClienteDto mapToClienteDto(Cliente cliente)


    {
        return new ClienteDto(
                cliente.getCodCliente(),
                cliente.getNome(),
                cliente.getCognome(),
                cliente.getEmail(),
                cliente.getRuolo(),
                cliente.getPassword()

        );
    }

    public static Cliente mapToCliente(ClienteDto clienteDto){

        Cliente cliente = new Cliente();

        cliente.setCodCliente(clienteDto.getCodCliente());
        cliente.setNome(clienteDto.getNome());
        cliente.setCognome(clienteDto.getCognome());
        cliente.setEmail(clienteDto.getEmail());
        cliente.setRuolo(clienteDto.getRuolo());
        cliente.setPassword(clienteDto.getPassword());

        return cliente;
    }


}
