package com.thiha.sneakershop.cartservice.model;

import java.util.UUID;
import java.util.Date;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "carts")
public class Cart {
   private UUID id;
   private String userId;
   private Date createdAt;
   private Date updatedAt;
   @OneToMany(mappedBy = "cart")
   private List<CartProduct> cartProducts;
}
