package o.rm.database.orm.service;

import o.rm.database.orm.repository.Product;

import java.util.List;

public interface ProductService {
    void insertProductJob();
    Product getProductByIdJob();
    long countHowManyJob();
    Iterable<Product> getAllProductsJob();
    List<Product> getAllProductsWithMinValueJob();
    String deleteProductByIdJob();
    String deleteAllProducts();

}
