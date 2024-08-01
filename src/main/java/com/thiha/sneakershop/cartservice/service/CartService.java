package com.thiha.sneakershop.cartservice.service;

import com.thiha.sneakershop.cartservice.dto.CartDto;
import com.thiha.sneakershop.cartservice.dto.CartRequest;

public interface CartService {
    CartDto findCartByUserId(String userId);
    CartDto createCart(String userId);
    CartDto addItemToCart(CartRequest request);
}
