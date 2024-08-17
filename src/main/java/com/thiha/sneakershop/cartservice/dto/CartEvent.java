package com.thiha.sneakershop.cartservice.dto;

import lombok.Data;

@Data
public class CartEvent {
    private String eventType;
    private CartDto cartDto;
}
