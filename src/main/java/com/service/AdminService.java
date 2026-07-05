package com.service;


import com.dto.ClienteDto;
import com.dto.ContoCorrenteDto;
import com.dto.MovimentoDto;

import java.util.List;
import java.util.Optional;

public interface AdminService {

    public List<ClienteDto> getAllClienti();

    public Optional<ClienteDto> getClienteById(Integer idCliente);

    public ContoCorrenteDto creaContoCorrente(Integer id);

    public ClienteDto aggiornaCliente(Integer id, ClienteDto dto);

    public void disattivaCliente(Integer id);

    public List<MovimentoDto> getMovimentiCliente(Integer idCliente);
}
