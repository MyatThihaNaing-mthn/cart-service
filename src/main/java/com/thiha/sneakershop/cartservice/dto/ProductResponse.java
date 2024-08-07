package com.thiha.sneakershop.cartservice.dto;

import java.util.Set;
import java.util.UUID;
import lombok.Data;

@Data
public class ProductResponse {
    private UUID id;
    private String name;
    private String brand;
    private String description;
    private String color;
    private double price;
    private double discount;
    private int sizeInUS;
    private int quantity;
    private Set<String> imageUrls;
}
