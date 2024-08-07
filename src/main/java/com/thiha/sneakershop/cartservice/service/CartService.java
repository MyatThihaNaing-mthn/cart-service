package com.thiha.sneakershop.cartservice.service;

import com.thiha.sneakershop.cartservice.dto.CartDto;
import com.thiha.sneakershop.cartservice.dto.CartRequest;
import java.util.UUID;

public interface CartService {
    CartDto findOrCreateCart(String userId);
    CartDto createCart(String userId);
    CartDto addItemToCart(CartRequest request, UUID cartId);
}
