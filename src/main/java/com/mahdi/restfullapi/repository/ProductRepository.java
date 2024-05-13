package com.mahdi.restfullapi.repository;

import com.mahdi.restfullapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM t_product WHERE c_name = ?1", nativeQuery = true)
    List<Product> getProductsByName(String productName);
}
