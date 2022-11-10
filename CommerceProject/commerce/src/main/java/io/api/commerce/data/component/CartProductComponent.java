package io.api.commerce.data.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.api.commerce.data.dto.CartDto;
import io.api.commerce.data.dto.CartProductDto;
import io.api.commerce.data.dto.ProductDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartProductComponent {
    public List<CartProductDto> getCartProducts(long cartId) {
        RestTemplate restTemplate = new RestTemplate();
        String baseUrl = "http://localhost:8082/api/shopping/cart/find/" + cartId;
        ResponseEntity<List<CartProductDto>> response = restTemplate.exchange(
                baseUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CartProductDto>>() {}
        );
        List<CartProductDto> cartProductDtos = response.getBody();
        return cartProductDtos.stream().collect(Collectors.toList());
    }
    public void saveCartProduct(CartProductDto cartProductDtoDto) {
        ObjectMapper mapper = new ObjectMapper();
        String url = "http://localhost:8082/api/shopping/cart/add";
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<CartProductDto> cartModelHttpEntity = new HttpEntity<>(cartProductDtoDto);
        restTemplate.postForObject(url, cartModelHttpEntity, CartProductDto.class);
    }
}
