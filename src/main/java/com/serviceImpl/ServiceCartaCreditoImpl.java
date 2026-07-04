package com.serviceImpl;

import com.dto.CartaCreditoDto;
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
    public List<CartaCreditoDto> getListaCartaCredito() {

        return repositoryConto.findAll().stream().map(CartaCreditoDto :: new).toList();
    }

    @Override
    public Optional<CartaCreditoDto> getCartaCreditoById(Integer id) {
        return repositoryConto.findById(id).map(CartaCreditoDto :: new);
    }


    @Override
    public CartaCreditoDto salvaCartaCredito(CartaCreditoDto cartaCreditoDto) {

        CartaCredito cartaCredito=new CartaCredito();
        cartaCredito.setNumCarta(cartaCreditoDto.getNumCarta());
        cartaCredito.setTipoCarta(cartaCreditoDto.getTipoCarta());
        cartaCredito.setCircuito(cartaCreditoDto.getCircuito());
        cartaCredito.setStato(cartaCreditoDto.getStato());
        cartaCredito.setPassword(cartaCreditoDto.getPassword());
        cartaCredito.setDataScadenza(cartaCreditoDto.getDataScadenza());

            CartaCredito cartaCreditoSalvato= repositoryConto.save(cartaCredito);
            return new CartaCreditoDto(cartaCreditoSalvato);
    }
}
