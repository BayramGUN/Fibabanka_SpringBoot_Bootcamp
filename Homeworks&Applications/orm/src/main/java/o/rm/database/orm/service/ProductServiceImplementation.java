package o.rm.database.orm.service;


import o.rm.database.orm.repository.Product;
import o.rm.database.orm.repository.ProductRepository;
import org.hibernate.dialect.function.AvgWithArgumentCastFunction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class ProductServiceImplementation implements ProductService {
    private ProductRepository productRepository;
    public ProductServiceImplementation(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public void insertProductJob() {
        Product product = new Product(0, "Telefon", 1430.5);
        Product product2 = new Product(0, "kağıt", 1130.5);
        Product product3 = new Product(0, "at", 1230.5);
        productRepository.save(product);
        productRepository.save(product2);
        productRepository.save(product3);
    }

    @Override
    public Product getProductByIdJob() {
        long id = 1;
        Optional<Product> optional = productRepository.findById(id);
        if(optional.isPresent())
        {
            Product product = optional.get();
            return product;
        }
        return null;
    }
    @Override
    public String deleteProductByIdJob() {
        long id = 3;
        if(!productRepository.existsById(id))
        {
            return "Ürün bulunamadı";
        }
        productRepository.deleteById(id);
        return "Silme başarılı";
    }

    @Override
    public String deleteAllProducts() {
        Iterable<Product> products = this.getAllProductsJob();
        productRepository.deleteAll(products);
        return "Hepsi silindi!";
    }

    @Override
    public Iterable<Product> getAllProductsJob() {
        Iterable<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    public List<Product> getAllProductsWithMinValueJob() {
        double minPrice = 1200.0;
        List<Product> products = productRepository.listByProductPriceMin(minPrice);
        return products;
    }

    @Override
    public long countHowManyJob() {
        Iterable<Product> products = productRepository.findAll();
        return StreamSupport.stream(products.spliterator(), false).count();
    }
}
