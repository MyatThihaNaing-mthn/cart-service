package com.thiha.sneakershop.cartservice.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class CartRequest {
    private UUID productId;
    private int quantity;
}
