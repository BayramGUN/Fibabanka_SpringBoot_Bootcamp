package io.api.shopping.service;

import io.api.shopping.enumeration.CartStatus;
import io.api.shopping.service.dto.CartDto;
import io.api.shopping.service.dto.CartProductDto;

public interface CartService {
    long createCart(CartDto cartDto);
    CartStatus updateCartStatus(long cartId);
    void deleteCart(long cartId);
    CartDto getCartById(long cartId);

    void addCartProduct(CartProductDto cartProductDto);
    void deleteCartProduct(long cartId, long cartProductId);
}
