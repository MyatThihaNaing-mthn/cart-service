package com.thiha.sneakershop.cartservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiha.sneakershop.cartservice.dto.CartDto;
import java.util.Date;
import java.util.UUID;
import java.util.List;
import com.thiha.sneakershop.cartservice.dto.CartRequest;
import com.thiha.sneakershop.cartservice.mapper.CartMapper;
import com.thiha.sneakershop.cartservice.model.Cart;
import com.thiha.sneakershop.cartservice.model.CartProduct;
import com.thiha.sneakershop.cartservice.repository.CartProductRepository;
import com.thiha.sneakershop.cartservice.repository.CartRepository;
import com.thiha.sneakershop.cartservice.service.CartService;
import com.thiha.sneakershop.cartservice.util.DateTimeHelper;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartProductRepository cartProductRepository;

    @Override
    public CartDto findCartByUserId(String userId) {
        Cart cart = cartRepository.findCardByUserId(userId).orElseThrow();
        
        return CartMapper.mapToCartDtoFromCart(cart);
    }

    @Override
    public CartDto createCart(String userId) {
        Date now = DateTimeHelper.getUtcNow();
        Cart cart = new Cart();
        cart.setCreatedAt(now);
        cart.setUpdatedAt(now);
        cart.setUserId(userId);

        Cart savedCart = cartRepository.save(cart);
        return CartMapper.mapToCartDtoFromCart(savedCart);
    }

    @Override
    public CartDto addItemToCart(CartRequest request, UUID cartId) {

        Cart cart = cartRepository.findById(cartId).orElseThrow();

        CartProduct newCartProduct = new CartProduct();
        newCartProduct.setCart(cart);
        newCartProduct.setProductId(request.getProductId());
        newCartProduct.setQuantity(request.getQuantity());
        CartProduct savedCartProduct =  cartProductRepository.save(newCartProduct);

        List<CartProduct> cartProducts = cart.getCartProducts();
        cartProducts.add(savedCartProduct);
        cart.setCartProducts(cartProducts);
        cartRepository.save(cart);

        return CartMapper.mapToCartDtoFromCart(cart);
    }
    
}
