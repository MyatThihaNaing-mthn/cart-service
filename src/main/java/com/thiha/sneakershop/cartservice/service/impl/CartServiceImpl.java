package com.thiha.sneakershop.cartservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiha.sneakershop.cartservice.dto.CartDto;
import com.thiha.sneakershop.cartservice.dto.CartRequest;
import com.thiha.sneakershop.cartservice.model.Cart;
import com.thiha.sneakershop.cartservice.repository.CartRepository;
import com.thiha.sneakershop.cartservice.service.CartService;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public CartDto findCartByUserId(String userId) {
        Cart cart = cartRepository.findCardByUserId(userId).orElseThrow();
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findCartByUserId'");
    }

    @Override
    public CartDto createCart(String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createCart'");
    }

    @Override
    public CartDto addItemToCart(CartRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addItemToCart'");
    }
    
}
