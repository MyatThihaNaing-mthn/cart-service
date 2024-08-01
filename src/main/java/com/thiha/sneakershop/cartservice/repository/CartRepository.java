package com.thiha.sneakershop.cartservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import java.util.Optional;
import com.thiha.sneakershop.cartservice.model.Cart;

public interface CartRepository extends JpaRepository<Cart, UUID>{
    Optional<Cart> findCardByUserId(String userId);
}
