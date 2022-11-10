package o.rm.database.orm.controller;

import o.rm.database.orm.repository.Product;
import o.rm.database.orm.repository.ProductRepository;
import o.rm.database.orm.service.ProductService;
import o.rm.database.orm.service.ProductServiceImplementation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/inventory")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    @ResponseBody
    public String insertProduct() {
        productService.insertProductJob();
        return "sokuldu!";
    }
    @GetMapping("/products")
    @ResponseBody
    public Iterable<Product> getAllProducts() {
        var response = productService.getAllProductsJob();
        return response;
    }
    @GetMapping("/product/{id}")
    @ResponseBody
    public Product getProductById() {
        var response = productService.getProductByIdJob();
        if(response == null) return null;
        return response;
    }
    @GetMapping("/product/count")
    @ResponseBody
    public long countHowMany() {
        var response = productService.countHowManyJob();
        return response;
    }
    @GetMapping("/product/delete")
    @ResponseBody
    public String DeleteProduct() {
        var response = productService.deleteProductByIdJob();
        return response;
    }
    @GetMapping("/products/delete")
    @ResponseBody
    public String DeleteAllProducts() {
        var response = productService.deleteAllProducts();
        return response;
    }
    @GetMapping("/products/from")
    @ResponseBody
    public List<Product> getAllProductsMinPrice() {
        var response = productService.getAllProductsWithMinValueJob();
        return response;
    }
}
