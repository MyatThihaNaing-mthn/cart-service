package com.thiha.sneakershop.cartservice.service;

import com.thiha.sneakershop.cartservice.dto.AddToCartRequest;
import com.thiha.sneakershop.cartservice.dto.CartDto;
import java.util.UUID;

public interface CartService {
    CartDto findOrCreateCart(String userId);
    CartDto createCart(String userId);
    CartDto addItemToCart(AddToCartRequest request, UUID cartId);
}
