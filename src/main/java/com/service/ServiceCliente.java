package com.service;

import com.dto.ClienteDto;

import java.util.Optional;

public interface ServiceCliente {

    ClienteDto creaCliente(ClienteDto clienteDto);
    Optional<ClienteDto> getClienteById(Integer clienteId);
}
