package io.api.shopping.service.mapping;

import io.api.shopping.data.entity.Cart;
import io.api.shopping.data.entity.CartProduct;
import io.api.shopping.service.dto.CartProductDto;

public interface CartProductMap {
    CartProductDto cartProductToCartProductDto(CartProduct cartProduct);
    CartProduct cartProductDtoToCartProduct(CartProductDto cartProductDto, Cart cart);
}
