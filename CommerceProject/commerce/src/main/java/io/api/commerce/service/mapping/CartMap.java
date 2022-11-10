package io.api.commerce.service.mapping;

import io.api.commerce.data.dto.CartDto;
import io.api.commerce.data.dto.CartProductDto;
import io.api.commerce.data.dto.ProductDto;
import io.api.commerce.service.model.CartModel;

import java.util.List;

public interface CartMap {
    CartDto fromCartModel(CartModel cartModel);
    CartModel fromCartDto(CartDto cartDto);
}
