package io.api.commerce.service;

import io.api.commerce.service.model.CartProductModel;
import io.api.commerce.service.model.ProductModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductService {
    ProductModel getProductById(long productId);
    List<ProductModel> getAllByCategory(String categoryName);
    void saveCartProduct(CartProductModel cartProductModel);

}
