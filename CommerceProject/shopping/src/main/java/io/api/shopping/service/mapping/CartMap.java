package io.api.shopping.service.mapping;

import io.api.shopping.data.entity.Cart;
import io.api.shopping.data.entity.CartProduct;
import io.api.shopping.service.dto.CartDto;
import io.api.shopping.service.dto.CartProductDto;

import java.util.List;

public interface CartMap {
    CartDto cartToCartDto(Cart cart, List<CartProductDto> cartProductDto);
    Cart cartDtoToCart(CartDto cartDto);
}
