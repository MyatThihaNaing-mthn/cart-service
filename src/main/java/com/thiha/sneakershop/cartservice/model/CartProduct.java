package com.thiha.sneakershop.cartservice.model;

import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "cart_products")
public class CartProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String productId;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;
}
