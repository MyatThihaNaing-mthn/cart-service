package com.thiha.sneakershop.cartservice.dto;

import java.util.Date;
import java.util.UUID;
import com.thiha.sneakershop.cartservice.model.CartProduct;
import java.util.List;
import lombok.Data;

@Data
public class CartDto {
    private UUID id;
    private String userId;
    private Date createdAt;
    private Date updatedAt;
    private List<CartProduct> cardProducts;
}
