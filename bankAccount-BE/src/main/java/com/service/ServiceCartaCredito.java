package com.service;


import com.dto.CartaCreditoRequestDto;

import java.util.List;
import java.util.Optional;

public interface ServiceCartaCredito {
    List<CartaCreditoRequestDto> getListaCartaCredito();
    Optional<CartaCreditoRequestDto> getCartaCreditoById(Integer id);
    CartaCreditoRequestDto salvaCartaCredito(CartaCreditoRequestDto cartaCreditoRequestDto);

    /*
            CartaCreditoResponseDto aggiornaCarta(Integer id,
                                              CartaCreditoRequestDto dto);

        void eliminaCarta(Integer id);

        List<CartaCreditoResponseDto> getCarteCliente(Integer codCliente);

        List<CartaCreditoResponseDto> getCarteConto(Integer idConto);

        void bloccaCarta(Integer id);

        void attivaCarta(Integer id);

        void cambiaPin(Integer id,
                       String nuovoPin);
    * */


}
