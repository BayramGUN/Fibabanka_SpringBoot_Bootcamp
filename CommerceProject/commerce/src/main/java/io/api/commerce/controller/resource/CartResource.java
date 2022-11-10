package io.api.commerce.controller.resource;

import io.api.commerce.service.implementaton.CartServiceImplementation;
import io.api.commerce.service.implementaton.ProductServiceImplementation;
import io.api.commerce.service.model.CartModel;
import io.api.commerce.service.model.CartProductModel;
import io.api.commerce.service.model.CartStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commerce/shopping")
public class CartResource {
    private final CartServiceImplementation cartServiceImplementation;
    private final ProductServiceImplementation productServiceImplementation;
    public CartResource(
            CartServiceImplementation cartServiceImplementation,
            ProductServiceImplementation productServiceImplementation
    ) {
        this.cartServiceImplementation = cartServiceImplementation;
        this.productServiceImplementation = productServiceImplementation;
    }

    @PostMapping("/cart/create")
    public long createCart(@RequestBody CartModel cartModel) {
        return cartServiceImplementation.createCart(cartModel);
    }
    @GetMapping("/cart/find/{id}")
    public CartModel getCartById(@PathVariable("id") long cartId) {
        return cartServiceImplementation.getCartById(cartId);
    }
    @GetMapping("/checkout/{id}")
    public CartStatus closeCart(@PathVariable("id") long cartId) {
        return cartServiceImplementation.closeCart(cartId);
    }
    @PostMapping("/cart/add")
    public String createCartProduct(@RequestBody CartProductModel cartProductModel) {
        productServiceImplementation.saveCartProduct(cartProductModel);
        return cartProductModel.getCartProductName();
    }
    @DeleteMapping("/cart/{cartId}/remove/{productId}")
    public String deleteCartProduct(
            @PathVariable("cartId") long cartId,
            @PathVariable("productId") long productId
    ) {
        return cartServiceImplementation.deleteProduct(cartId, productId);
    }
}

