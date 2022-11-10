package io.api.commerce.service;

import io.api.commerce.data.dto.CartDto;
import io.api.commerce.service.model.CartModel;
import io.api.commerce.service.model.CartProductModel;
import io.api.commerce.service.model.CartStatus;
import org.springframework.http.ResponseEntity;

public interface CartService {
    long createCart(CartModel cartModel);
    CartModel getCartById(long cartId);
    CartStatus closeCart(long cartId);
    String deleteProduct(long cartId, long productId);
}
