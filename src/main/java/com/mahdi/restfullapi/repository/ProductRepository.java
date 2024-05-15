package com.mahdi.restfullapi.repository;

import com.mahdi.restfullapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM t_product WHERE c_name = ?1", nativeQuery = true)
    Product getProductsByName(String productName);
}
