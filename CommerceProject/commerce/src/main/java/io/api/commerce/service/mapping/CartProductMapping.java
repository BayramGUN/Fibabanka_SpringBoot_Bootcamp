package io.api.commerce.service.mapping;

import io.api.commerce.data.dto.CartProductDto;
import io.api.commerce.service.model.CartProductModel;
import org.springframework.stereotype.Component;

@Component
public class CartProductMapping implements CartProductMap{
    @Override
    public CartProductModel fromCartProductDto(CartProductDto cartProductDto) {
        CartProductModel cartProductModel = new CartProductModel();
        cartProductModel.setCartId(cartProductDto.getCartId());
        cartProductModel.setCartProductId(cartProductDto.getCartProductId());
        cartProductModel.setCartProductName(cartProductDto.getCartProductName());
        cartProductModel.setSalesPrice(cartProductDto.getSalesPrice());
        return cartProductModel;
    }

    @Override
    public CartProductDto fromCartProductModel(CartProductModel cartProductModel) {
        CartProductDto cartProductDto = new CartProductDto();
        cartProductDto.setCartId(cartProductModel.getCartId());
        cartProductDto.setSalesPrice(cartProductModel.getSalesPrice());
        cartProductDto.setSalesQuantity(cartProductModel.getSalesQuantity());
        cartProductDto.setProductId(cartProductModel.getProductId());
        return cartProductDto;
    }
}
