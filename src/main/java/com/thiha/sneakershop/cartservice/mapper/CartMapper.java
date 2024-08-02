package com.thiha.sneakershop.cartservice.mapper;

import java.util.List;
import java.util.stream.Collectors;
import com.thiha.sneakershop.cartservice.dto.CartDto;
import com.thiha.sneakershop.cartservice.dto.CartProductDto;
import com.thiha.sneakershop.cartservice.model.Cart;
import com.thiha.sneakershop.cartservice.model.CartProduct;

public class CartMapper {
    public static CartDto mapToCartDtoFromCart(Cart cart){
        CartDto dto = new CartDto();
        dto.setId(cart.getId());
        dto.setUserId(cart.getUserId());
        List<CartProductDto> cartProductDtos = cart.getCartProducts().stream()
                                                    .map(cartProduct -> CartMapper.mapToCartProductDtoFromCartProduct(cartProduct))
                                                    .collect(Collectors.toList());
        dto.setCardProducts(cartProductDtos);
        dto.setCreatedAt(cart.getCreatedAt());
        dto.setUpdatedAt(cart.getUpdatedAt());
        
        return dto;
    }

    public static CartProductDto mapToCartProductDtoFromCartProduct(CartProduct cartProduct){
        CartProductDto dto = new CartProductDto();
        dto.setId(cartProduct.getId());
        dto.setProductId(cartProduct.getProductId());
        dto.setQuantity(cartProduct.getQuantity());

        return dto;
    }
}
