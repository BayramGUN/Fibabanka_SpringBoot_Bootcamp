package io.api.commerce.service.implementaton;

import io.api.commerce.data.component.CartProductComponent;
import io.api.commerce.data.component.ProductComponent;
import io.api.commerce.data.dto.ProductDto;
import io.api.commerce.service.ProductService;
import io.api.commerce.service.mapping.CartProductMapping;
import io.api.commerce.service.mapping.ProductMapping;
import io.api.commerce.service.model.CartProductModel;
import io.api.commerce.service.model.ProductModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductServiceImplementation implements ProductService {
    private final ProductComponent productComponent;
    private final ProductMapping productMapping;
    private final CartProductComponent cartProductComponent;
    private final CartProductMapping cartProductMapping;

    public ProductServiceImplementation(
            ProductComponent productComponent,
            ProductMapping productMapping,
            CartProductComponent cartProductComponent,
            CartProductMapping cartProductMapping
    ) {
        this.productComponent = productComponent;
        this.productMapping = productMapping;
        this.cartProductComponent = cartProductComponent;
        this.cartProductMapping = cartProductMapping;
    }
    @Override
    public ProductModel getProductById(long productId) {
        return productMapping.prodoctDtoToProductModel(productComponent.getProductById(productId));
    }

    @Override
    public List<ProductModel> getAllByCategory(String categoryName) {
        List<ProductDto> productDtos = productComponent.getAllByCategory(categoryName);
        List<ProductModel> productModels = new ArrayList<>();
        for(ProductDto productDto : productDtos) {
            productModels.add(productMapping.prodoctDtoToProductModel(productDto));
        }
        return productModels;
    }
    @Override
    public void saveCartProduct(CartProductModel cartProductModel) {
        ProductDto productDto = productComponent.getProductById(cartProductModel.getProductId());

        cartProductModel.setCartProductName(productDto.getProductName());
        cartProductModel.setSalesPrice(productDto.getSalesPrice());
        cartProductComponent.saveCartProduct(cartProductMapping
                .fromCartProductModel(cartProductModel));
    }

}
