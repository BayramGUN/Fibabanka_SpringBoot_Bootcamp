package io.api.commerce.service.mapping;

import io.api.commerce.data.dto.CartDto;
import io.api.commerce.data.dto.ProductDto;
import io.api.commerce.service.model.CartModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartMapping implements CartMap{
    @Override
    public CartDto fromCartModel(CartModel cartModel) {
        CartDto cartDto = new CartDto();
        cartDto.setCustomerName(cartModel.getCustomerName());
        return cartDto;
    }

    @Override
    public CartModel fromCartDto(CartDto cartDto) {
        CartModel cartModel = new CartModel();
        cartModel.setCustomerName(cartDto.getCustomerName());
        cartModel.setTotalAmount(cartDto.getTotalAmount());
        cartModel.setCartProductDtos(cartDto.getCartProductDtos());
        return cartModel;
    }
}
