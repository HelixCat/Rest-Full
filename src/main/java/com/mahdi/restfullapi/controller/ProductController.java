package com.mahdi.restfullapi.controller;

import com.mahdi.restfullapi.dto.ProductDTO;
import com.mahdi.restfullapi.model.Product;
import com.mahdi.restfullapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    // insert a product into database
    @PostMapping("/product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }


    @GetMapping("/product")
    public ResponseEntity<ProductDTO> findProductById(@RequestParam(name = "productId") long productId) {
        ProductDTO productDTO = productService.getProduct(productId);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }


    @GetMapping("/products")
    public List<Product> findAllProduct() {
        return productService.getProducts();
    }


    @PatchMapping("/product")
    public ResponseEntity<Product> updateProductById(@RequestParam(name ="productId") long productId, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(productId, product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }


    @DeleteMapping("/product")
    public ResponseEntity<Product> deleteProductById(@RequestParam(name ="productId") long productId) {
        Product deletedProduct = productService.deleteproduct(productId);
        return new ResponseEntity<>(deletedProduct, HttpStatus.OK);
    }



    @GetMapping("/products-by-name")
    public List<Product> getProductsByName(@RequestParam(name ="productName") String productName) {
        return productService.getProductsByName(productName);
    }
}
