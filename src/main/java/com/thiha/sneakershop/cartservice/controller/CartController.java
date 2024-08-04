package com.thiha.sneakershop.cartservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.thiha.sneakershop.cartservice.dto.CartDto;
import com.thiha.sneakershop.cartservice.service.CartService;

@RestController
public class CartController {
    @Autowired
    private CartService cartService;

    public ResponseEntity<CartDto> getCart(){
        CartDto cart = cartService.findCartByUserId("id");
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }
}
