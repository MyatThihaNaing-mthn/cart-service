package com.thiha.sneakershop.cartservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiha.sneakershop.cartservice.dto.AddToCartRequest;
import com.thiha.sneakershop.cartservice.dto.CartDto;
import java.util.Date;
import java.util.UUID;
import java.util.List;
import java.util.Optional;
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
    public CartDto findOrCreateCart(String userId) {
        Optional<Cart> cart = cartRepository.findCardByUserId(userId);
        if (!cart.isPresent()) {
            Cart newCart = new Cart();
            Date now = DateTimeHelper.getUtcNow();
            newCart.setUserId(userId);
            newCart.setCartProducts(null);
            newCart.setCreatedAt(now);
            newCart.setUpdatedAt(now);
            Cart savedCart = cartRepository.save(newCart);
            return CartMapper.mapToCartDtoFromCart(savedCart);
        }
        return CartMapper.mapToCartDtoFromCart(cart.get());
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
    public CartDto addItemToCart(AddToCartRequest request, UUID cartId) {

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
