package io.api.commerce.data.component;

import io.api.commerce.data.dto.CategoryDto;
import io.api.commerce.data.dto.ProductDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ProductComponent {
    public ProductDto getProductById(long productId) {
        String baseUrl = "http://localhost:8081/api/inventory/product/";
        RestTemplate restTemplate = new RestTemplate();
        ProductDto productDto = restTemplate.getForObject(baseUrl + productId, ProductDto.class);
        return productDto;
    }
   public List<ProductDto> getAllByCategory(String categoryName) {
       RestTemplate restTemplate = new RestTemplate();
       String baseUrl = "http://localhost:8081/api/inventory/product";
       String url = baseUrl + "s/" + categoryName;
       ResponseEntity<List<ProductDto>> response = restTemplate.exchange(
               url,
               HttpMethod.GET,
               null,
               new ParameterizedTypeReference<List<ProductDto>>() {}
       );
       List<ProductDto> productDtos = response.getBody();
       return productDtos.stream().collect(Collectors.toList());
   }
   public List<CategoryDto> getCategories() {
       RestTemplate restTemplate = new RestTemplate();
       String baseUrl = "http://localhost:8081/api/inventory/categories";
       ResponseEntity<List<CategoryDto>> response = restTemplate.exchange(
               baseUrl,
               HttpMethod.GET,
               null,
               new ParameterizedTypeReference<List<CategoryDto>>() {}
       );
       List<CategoryDto> categoryDtos = response.getBody();

       return categoryDtos.stream().collect(Collectors.toList());
   }
}
