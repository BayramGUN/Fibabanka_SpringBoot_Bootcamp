package io.api.shopping.service.mapping;

import io.api.shopping.data.entity.Cart;
import io.api.shopping.data.entity.CartProduct;
import io.api.shopping.data.repository.CartRepository;
import io.api.shopping.service.dto.CartProductDto;
import org.springframework.stereotype.Component;

@Component
public class CartProductMapping implements CartProductMap{
    @Override
    public CartProductDto cartProductToCartProductDto(CartProduct cartProduct) {
        CartProductDto cartProductDto = new CartProductDto();
        cartProductDto.setCartProductId(cartProduct.getCartProductId());
        cartProductDto.setSalesPrice(cartProduct.getSalesPrice());
        cartProductDto.setSalesQuantity(cartProduct.getSalesQuantity());
        cartProductDto.setLineAmount(cartProduct.getLineAmount());
        cartProductDto.setProductId(cartProduct.getProductId());
        cartProductDto.setCartId(cartProduct.getCart().getCartId());
        return cartProductDto;
    }

    @Override
    public CartProduct cartProductDtoToCartProduct(CartProductDto cartProductDto, Cart cart) {
        CartProduct cartProduct = new CartProduct();
        cartProduct.setCartProductId(cartProductDto.getCartProductId());
        cartProduct.setSalesPrice(cartProductDto.getSalesPrice());
        cartProduct.setSalesQuantity(cartProductDto.getSalesQuantity());
        cartProduct.setLineAmount(cartProductDto.getLineAmount());
        cartProduct.setProductId(cartProductDto.getProductId());
        cartProduct.setCart(cart);
        return cartProduct;
    }
}
