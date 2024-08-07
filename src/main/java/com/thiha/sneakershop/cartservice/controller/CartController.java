package com.thiha.sneakershop.cartservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.thiha.sneakershop.cartservice.dto.CartDto;
import com.thiha.sneakershop.cartservice.dto.CartRequest;
import com.thiha.sneakershop.cartservice.dto.ProductResponse;
import com.thiha.sneakershop.cartservice.dto.UserResponse;
import com.thiha.sneakershop.cartservice.service.CartService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/add")
    public ResponseEntity<CartDto> addToCart(HttpServletRequest request,
            @RequestBody CartRequest cartRequest){
        String token = extractJwtFromRequest(request);
        System.out.println("Entry");
        if(token == null){
            System.out.println("Token null");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer "+ token);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        // TODO use config for constant
        String userServiceUrl = "http://USERSERVICE/api/customer";

        ResponseEntity<UserResponse> response = restTemplate.exchange(userServiceUrl, 
                HttpMethod.GET, 
                entity,
                UserResponse.class);
        if(response.getStatusCode() != HttpStatus.OK){
            System.out.println("Response error");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        if ("Admin".equals(response.getBody().getRole())) {
            System.out.println("Forbidden admin");
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        String userId = response.getBody().getId();
        CartDto cart = cartService.findOrCreateCart(userId);
        
        // TODO check product quantity with product service
        String productId = cartRequest.getProductId();
        String productServiceUrl = "http://PRODUCTSERVICE/api/product/";
        ResponseEntity<ProductResponse> productResponse = restTemplate.exchange(productServiceUrl+productId, 
                    HttpMethod.GET, 
                    null, 
                    ProductResponse.class);
        if(productResponse.getStatusCode() != HttpStatus.OK){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(productResponse.getBody().getQuantity() < cartRequest.getQuantity()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        CartDto updatedCart =  cartService.addItemToCart(cartRequest, cart.getId());
        return new ResponseEntity<>(updatedCart, HttpStatus.OK);
    }

    private String extractJwtFromRequest(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");
        if(bearerToken != null && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7);
        }
        return null;
    }
}
