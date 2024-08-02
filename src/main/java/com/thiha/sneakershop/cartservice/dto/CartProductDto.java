package com.thiha.sneakershop.cartservice.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class CartProductDto {
    private UUID id;
    private String productId;
    private int quantity;
}
