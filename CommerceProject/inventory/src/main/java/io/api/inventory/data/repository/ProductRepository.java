package io.api.inventory.data.repository;


import io.api.inventory.data.entity.Category;
import io.api.inventory.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long>, JpaRepository<Product, Long> {
    @Query("select p from Product p where p.category.categoryName = :categoryName")
    List<Product> findAllByCategoryId(@Param("categoryName") String categoryName);
}
