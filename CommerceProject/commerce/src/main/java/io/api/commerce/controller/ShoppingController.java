package io.api.commerce.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.api.commerce.service.model.CartModel;
import io.api.commerce.service.model.CartProductModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/commerce/shopping")
public class ShoppingController {
    @GetMapping("/cart/create")
    @ResponseBody
    public String cartCreate(){
        CartModel cartModel = new CartModel();
        cartModel.setCustomerName("new customer");
        ObjectMapper mapper = new ObjectMapper();
        String url = "http://localhost:8080/api/shopping/cart/create";
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<CartModel> cartModelHttpEntity = new HttpEntity<>(cartModel);
        ResponseEntity<Long> cartResponse = restTemplate.exchange(url, HttpMethod.POST ,cartModelHttpEntity, Long.class);
        return "Cart is created<br>" + "cart id: <b>" + cartResponse.getBody() + "</b>";
    }
    @GetMapping("cart/add")
    @ResponseBody
    public String createcartProduct() {
       CartProductModel cartProductModel = new CartProductModel();
       cartProductModel.setCartId(21);
       cartProductModel.setCartProductId(1);
       cartProductModel.setSalesQuantity(1);
       ObjectMapper mapper = new ObjectMapper();
       String url = "http://localhost:8080/api/shopping/cart/add";
       RestTemplate restTemplate = new RestTemplate();
       HttpEntity<CartProductModel> cartProductModelHttpEntity = new HttpEntity<>(cartProductModel);
       ResponseEntity<Long> cartProductResponse = restTemplate.exchange(url, HttpMethod.POST, cartProductModelHttpEntity, Long.class);
       if(cartProductResponse.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) return "added but same database problem";
       return "CartProduct is created! <b> " + cartProductResponse.getStatusCode() + "</b>";
    }
    @GetMapping("/cart/{cartId}/remove/{productId}")
    @ResponseBody
    public String deleteProduct(
            @PathVariable("cartId") long cartId,
            @PathVariable("productId") long productId
    ) {
        String baseUrl = "http://localhost:8080/api/shopping/cart/" + cartId + "/remove/" + productId;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(baseUrl, HttpMethod.DELETE, null, String.class).getBody();
    }
}
