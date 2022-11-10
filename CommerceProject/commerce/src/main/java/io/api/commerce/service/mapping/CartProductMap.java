package io.api.commerce.service.mapping;

import io.api.commerce.data.dto.CartProductDto;
import io.api.commerce.service.model.CartProductModel;
import io.api.commerce.service.model.CartStatus;
import org.springframework.stereotype.Component;

@Component
public interface CartProductMap {
    CartProductModel fromCartProductDto(CartProductDto cartProductDto);
    CartProductDto fromCartProductModel(CartProductModel cartProductModel);
}
