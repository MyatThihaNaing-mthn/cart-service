package com.thiha.sneakershop.cartservice.dto;

import lombok.Data;

@Data
public class AddToCartRequest {
    private String productId;
    private int quantity;
}
