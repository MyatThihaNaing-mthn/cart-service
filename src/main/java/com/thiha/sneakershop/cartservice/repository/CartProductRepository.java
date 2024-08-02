package com.thiha.sneakershop.cartservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import com.thiha.sneakershop.cartservice.model.CartProduct;

public interface CartProductRepository extends JpaRepository<CartProduct, UUID>{
    
}
