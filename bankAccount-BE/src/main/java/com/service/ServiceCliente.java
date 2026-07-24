package com.service;

import com.dto.ClienteDto;

import java.util.List;

public interface ServiceCliente {

    List<ClienteDto> findAll();

    ClienteDto findById(Integer id);

    ClienteDto save(ClienteDto dto);

    ClienteDto update(Integer id, ClienteDto dto);

    void delete(Integer id);

    ClienteDto findByEmail(String email);
}
