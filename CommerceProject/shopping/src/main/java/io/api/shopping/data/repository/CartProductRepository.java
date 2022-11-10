package io.api.shopping.data.repository;

import io.api.shopping.data.entity.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartProductRepository extends CrudRepository<CartProduct, Long>, JpaRepository<CartProduct, Long> {
    @Query("select c from CartProduct c where c.cart.cartId = :cartId")
    List<CartProduct> findAllByCartId(@Param("cartId") long cartId);
    //@Query("select c from CartProduct c where c.cart.cartId = :cartId")
    //CartProduct findByCartId(@Param("cartId") long cartId);
}
