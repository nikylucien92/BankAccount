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
                cliente.getSaldoContoCorrente(),
                cliente.getNumConto()
        );
    }

    public static Cliente mapToCliente(ClienteDto clienteDto){

        return new Cliente(
                clienteDto.getCodCliente(),
                clienteDto.getNome(),
                clienteDto.getCognome(),
                clienteDto.getEmail(),
                clienteDto.getSaldoContoCorrente(),
                clienteDto.getNumConto()
        );
    }


}
