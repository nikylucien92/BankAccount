package com.service;

import com.dto.ClienteDto;

import java.util.List;
import java.util.Optional;

public interface ServiceCliente {

    ClienteDto creaCliente(ClienteDto clienteDto);
    Optional<ClienteDto> getClienteById(Integer clienteId);

    List<ClienteDto> getAllClienti();

    ClienteDto updateCliente(Integer codCliente,ClienteDto clienteDto);

    void deleteCliente(Integer codCliente);
}
