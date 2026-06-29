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
                cliente.getNumConto(),
                cliente.getRuolo()

        );
    }

    public static Cliente mapToCliente(ClienteDto clienteDto){

        Cliente cliente = new Cliente();

        cliente.setCodCliente(clienteDto.getCodCliente());
        cliente.setNome(clienteDto.getNome());
        cliente.setCognome(clienteDto.getCognome());
        cliente.setEmail(clienteDto.getEmail());
        cliente.setSaldoContoCorrente(clienteDto.getSaldoContoCorrente());
        cliente.setNumConto(clienteDto.getNumConto());
        cliente.setRuolo(clienteDto.getRuolo());

        return cliente;
    }


}
