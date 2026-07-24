package com.serviceImpl;

import com.dto.CartaCreditoRequestDto;
import com.entity.CartaCredito;
import com.repository.RepositoryCartaCredito;
import com.service.ServiceCartaCredito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCartaCreditoImpl implements ServiceCartaCredito {

    @Autowired
    RepositoryCartaCredito repositoryConto;

    @Override
    public List<CartaCreditoRequestDto> getListaCartaCredito() {

        return repositoryConto.findAll().stream().map(CartaCreditoRequestDto:: new).toList();
    }

    @Override
    public Optional<CartaCreditoRequestDto> getCartaCreditoById(Integer id) {
        return repositoryConto.findById(id).map(CartaCreditoRequestDto:: new);
    }


    @Override
    public CartaCreditoRequestDto salvaCartaCredito(CartaCreditoRequestDto cartaCreditoRequestDto) {

        CartaCredito cartaCredito=new CartaCredito();
        cartaCredito.setIdCarta(cartaCreditoRequestDto.getIdCarta());
        cartaCredito.setNumCarta(cartaCreditoRequestDto.getNumCarta());
        cartaCredito.setCircuito(cartaCreditoRequestDto.getCircuito());
        cartaCredito.setDataScadenza(cartaCreditoRequestDto.getDataScadenza());
        cartaCredito.setStatoCarta(cartaCreditoRequestDto.getStato());
            CartaCredito cartaCreditoSalvato= repositoryConto.save(cartaCredito);
            return new CartaCreditoRequestDto(cartaCreditoSalvato);
    }
}
