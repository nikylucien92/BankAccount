package com.service;


import com.dto.CartaCreditoDto;

import java.util.List;
import java.util.Optional;

public interface ServiceCartaCredito {
    List<CartaCreditoDto> getListaCartaCredito();
    Optional<CartaCreditoDto> getCartaCreditoById(Integer id);
    CartaCreditoDto salvaCartaCredito(CartaCreditoDto cartaCreditoDto);
}
