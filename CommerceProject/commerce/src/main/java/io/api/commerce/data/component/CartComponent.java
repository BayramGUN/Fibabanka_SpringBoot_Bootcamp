package io.api.commerce.data.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.api.commerce.data.dto.CartDto;
import io.api.commerce.data.dto.ProductDto;
import io.api.commerce.service.model.CartStatus;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CartComponent {
    public long saveCart(CartDto cartDto) {
        ObjectMapper mapper = new ObjectMapper();
        String url = "http://localhost:8082/api/shopping/cart/create";
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<CartDto> cartModelHttpEntity = new HttpEntity<>(cartDto);
        ResponseEntity<Long> cartId = restTemplate.exchange(url, HttpMethod.POST ,cartModelHttpEntity, Long.class);
        return cartId.getBody();
    }
    public CartDto getCartById(long cartId) {
        String baseUrl = "http://localhost:8082/api/shopping/cart/find/";
        RestTemplate restTemplate = new RestTemplate();
        CartDto cartDto = restTemplate.getForObject(baseUrl + cartId, CartDto.class);
        return cartDto;
    }
    public CartStatus closeCart(long cartId) {
        String baseUrl = "http://localhost:8082/api/shopping/checkout/" + cartId;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CartStatus> cartStatus = restTemplate.getForEntity(baseUrl, CartStatus.class);
        return cartStatus.getBody();
    }
    public void removeCartProduct(long cartId, long productId) {
        String baseUrl = "http://localhost:8082/api/shopping/cart/" + cartId + "/remove/" + productId;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(baseUrl);
    }
}
