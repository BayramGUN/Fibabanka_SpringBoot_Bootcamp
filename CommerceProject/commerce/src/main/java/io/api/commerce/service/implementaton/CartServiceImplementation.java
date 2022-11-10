package io.api.commerce.service.implementaton;

import io.api.commerce.data.component.CartComponent;
import io.api.commerce.data.component.ProductComponent;
import io.api.commerce.data.dto.CartDto;
import io.api.commerce.data.dto.CartProductDto;
import io.api.commerce.data.dto.ProductDto;
import io.api.commerce.service.CartService;
import io.api.commerce.service.mapping.CartMapping;
import io.api.commerce.service.model.CartModel;
import io.api.commerce.service.model.CartProductModel;
import io.api.commerce.service.model.CartStatus;
import io.api.commerce.service.model.ProductModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImplementation implements CartService {
    private final CartComponent cartComponent;
    private final CartMapping cartMapping;
    private final ProductComponent productComponent;


    public CartServiceImplementation(
            CartComponent cartComponent,
            CartMapping cartMapping,
            ProductComponent productComponent) {
        this.cartComponent = cartComponent;
        this.cartMapping = cartMapping;
        this.productComponent = productComponent;
    }

    @Override
    public long createCart (CartModel cartModel) {
        return cartComponent.saveCart(cartMapping.fromCartModel(cartModel));
    }

    @Override
    public CartModel getCartById(long cartId) {
        CartDto cartDto = cartComponent.getCartById(cartId);
        for (CartProductDto cartProductDto : cartDto.getCartProductDtos()) {
            cartProductDto.setCartProductName(productComponent.getProductById(cartProductDto.getProductId()).getProductName());
        }
        return cartMapping.fromCartDto(cartDto);
    }

    @Override
    public CartStatus closeCart(long cartId) {
        return cartComponent.closeCart(cartId);
    }

    @Override
    public String deleteProduct(long cartId, long productId) {
        CartDto cartDto = cartComponent.getCartById(cartId);
        if(cartDto == null)
            return "There is nothing to delete!";
        cartComponent.removeCartProduct(cartId, productId);
        return cartDto.getCartId() + " deleted successfully!";
    }


}
