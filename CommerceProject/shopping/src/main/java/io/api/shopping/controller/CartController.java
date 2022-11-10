package io.api.shopping.controller;

import io.api.shopping.data.entity.Cart;
import io.api.shopping.enumeration.CartStatus;
import io.api.shopping.service.dto.CartDto;
import io.api.shopping.service.dto.CartProductDto;
import io.api.shopping.service.implementation.CartServiceImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/api/shopping")
public class CartController {
    private final CartServiceImplementation cartServiceImplementation;

    public CartController(CartServiceImplementation cartServiceImplementation) {
        this.cartServiceImplementation = cartServiceImplementation;
    }

    @GetMapping("/checkout/{id}")
    public CartStatus seeCartStatus(@PathVariable("id") long cartId) {
        return cartServiceImplementation.updateCartStatus(cartId);
    }

    @PostMapping("/cart/create")
    public long createCart(@RequestBody CartDto cartDto) {
        return cartServiceImplementation.createCart(cartDto);
    }
    @DeleteMapping("/cart/delete/{id}")
    public ResponseEntity<String> deleteCart(@PathVariable("id") long cartId) {
        cartServiceImplementation.deleteCart(cartId);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body("HTTP Status will be ACCEPTED (CODE 202)\n");
    }
    @DeleteMapping("/cart/{cartId}/remove/{productId}")
    public void removeCartProduct(
            @PathVariable("cartId") long cartId,
            @PathVariable("productId") long productId) {
        cartServiceImplementation.deleteCartProduct(cartId, productId);
    }
    @GetMapping("/cart/find/{id}")
    public CartDto findCart(@PathVariable("id") long cartId) {
        return cartServiceImplementation.getCartById(cartId);
    }
    @PostMapping("/cart/add")
    public long createCartProduct(@RequestBody CartProductDto cartProductDto) {
        cartServiceImplementation.addCartProduct(cartProductDto);
	  return cartProductDto.getCartProductId();
    }
}
