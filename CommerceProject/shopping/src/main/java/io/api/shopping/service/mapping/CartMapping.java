package io.api.shopping.service.mapping;

import io.api.shopping.data.entity.Cart;
import io.api.shopping.data.entity.CartProduct;
import io.api.shopping.enumeration.CartStatus;
import io.api.shopping.service.dto.CartDto;
import io.api.shopping.service.dto.CartProductDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartMapping implements CartMap{
    @Override
    public CartDto cartToCartDto(Cart cart, List<CartProductDto> cartProductDto) {
        CartDto cartDto = new CartDto();
        cartDto.setCartId(cart.getCartId());
        cartDto.setCartProductDtos(cartProductDto);
        cartDto.setCustomerName(cart.getCustomerName());
        cartDto.setTotalAmount(cart.getTotalAmount());
        return cartDto;
    }

    @Override
    public Cart cartDtoToCart(CartDto cartDto) {
        Cart cart = new Cart();
        cart.setCartStatus(CartStatus.NEW);
        cart.setCartId(cartDto.getCartId());
        cart.setTotalAmount(cartDto.getTotalAmount());
        cart.setCustomerName(cartDto.getCustomerName());
        return cart;
    }
}
