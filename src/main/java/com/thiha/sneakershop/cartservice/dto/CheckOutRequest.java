package com.thiha.sneakershop.cartservice.dto;

import java.util.List;

import lombok.Data;

@Data
public class CheckOutRequest {
    private List<AddToCartRequest> checkOutRequest;
}
