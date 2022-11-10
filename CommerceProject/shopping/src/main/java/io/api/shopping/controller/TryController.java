package io.api.shopping.controller;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.api.shopping.data.entity.Cart;
import io.api.shopping.service.dto.CartDto;
import io.api.shopping.service.dto.CartProductDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.io.StringWriter;
import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/try")
public class TryController {
    @GetMapping("/add")
    @ResponseBody
    public String ok() {

        CartDto cartDto = new CartDto();
        List<CartProductDto> cartProductDtoList = new ArrayList<>();
        CartProductDto cartProductDto = new CartProductDto();
        cartProductDto.setCartId(1);
        cartProductDto.setCartProductId(1);
        cartProductDto.setSalesPrice(100);
        cartProductDto.setSalesQuantity(1);
        cartProductDtoList.add(cartProductDto);
        cartDto.setCustomerName("babayram");
        cartDto.setCartProductDtos(cartProductDtoList);
        cartDto.setTotalAmount(123);
        ObjectMapper mapper = new ObjectMapper();

        String url = "http://localhost:8082/api/shopping/cart/create";
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<CartDto> cartDtoHttpEntity = new HttpEntity<>(cartDto);
        restTemplate.exchange(url, HttpMethod.POST ,cartDtoHttpEntity, Long.class);

        return "responseBody";
    }
}
