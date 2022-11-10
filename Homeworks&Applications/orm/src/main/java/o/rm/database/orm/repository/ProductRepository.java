package o.rm.database.orm.repository;

import o.rm.database.orm.repository.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository
        extends JpaRepository<Product, Long> {

    @Query("select p from Product as p where p.salesPrice >= :minPrice")
    List<Product> listByProductPriceMin(@Param("minPrice") double minPrice);

}
