package io.api.shopping.service.implementation;

import io.api.shopping.data.entity.Cart;
import io.api.shopping.data.entity.CartProduct;
import io.api.shopping.data.repository.CartProductRepository;
import io.api.shopping.data.repository.CartRepository;
import io.api.shopping.enumeration.CartStatus;
import io.api.shopping.service.CartService;
import io.api.shopping.service.dto.CartDto;
import io.api.shopping.service.dto.CartProductDto;
import io.api.shopping.service.mapping.CartMapping;
import io.api.shopping.service.mapping.CartProductMapping;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImplementation implements CartService {
    private final CartRepository cartRepository;
    private final CartProductRepository cartProductRepository;
    private final CartMapping cartMapping;
    private final CartProductMapping cartProductMapping;

    public CartServiceImplementation(
            CartRepository cartRepository,
            CartProductRepository cartProductRepository,
            CartMapping cartMapping,
            CartProductMapping cartProductMapping) {
        this.cartRepository = cartRepository;
        this.cartProductRepository = cartProductRepository;
        this.cartMapping = cartMapping;
        this.cartProductMapping = cartProductMapping;
    }

    @Override
    public long createCart(CartDto cartDto) {
        Cart cart = cartRepository.save(cartMapping.cartDtoToCart(cartDto));
        return cart.getCartId();
    }

    @Override
    public CartStatus updateCartStatus(long cartId) {
        Cart cart = cartRepository.getReferenceById(cartId);
        cart.setCartStatus(CartStatus.DONE);
        double totalAmount = cart.getTotalAmount();
        List<CartProduct> cartProductList = cartProductRepository.findAllByCartId(cartId);
        for (CartProduct cartProduct : cartProductList) {
            totalAmount += cartProduct.getLineAmount();
        }
        cart.setTotalAmount(totalAmount);
        cartRepository.save(cart);
        return cart.getCartStatus();
    }

    @Override
    public void deleteCart(long cartId) {
        Cart cart = cartRepository.getReferenceById(cartId);
        if(cart == null) System.out.println("there is no cart in this id");
        cartRepository.deleteById(cartId);
    }

    @Override
    public CartDto getCartById(long cartId) {
        List<CartProduct> cartProductList = cartProductRepository.findAllByCartId(cartId);
        List<CartProductDto> cartProductDtos = new ArrayList<>();
        long totalAmount = 0;
        for (CartProduct cartProduct: cartProductList) {
            cartProductDtos.add(cartProductMapping.cartProductToCartProductDto(cartProduct));
            totalAmount += cartProduct.getLineAmount();
        }

        CartDto cartDto = cartMapping.cartToCartDto(
                cartRepository.getReferenceById(cartId),
                cartProductDtos
        );

        cartDto.setTotalAmount(totalAmount);
        return cartDto;
    }

    @Override
    public void addCartProduct(CartProductDto cartProductDto) {
        cartProductDto.setLineAmount(cartProductDto.getSalesPrice() * cartProductDto.getSalesQuantity());
        Cart cart = cartRepository.getReferenceById(cartProductDto.getCartId());
        cartProductRepository.save(cartProductMapping.cartProductDtoToCartProduct(cartProductDto, cart));
    }

    @Override
    public void deleteCartProduct(long cartId, long cartProductId) {
        Cart cart = cartRepository.getReferenceById(cartId);
        CartProduct cartProduct = cartProductRepository.getReferenceById(cartProductId);

        if(cart.getCartId() == cartProduct.getCart().getCartId())
            cartProductRepository.deleteById(cartProductId);
    }
}
