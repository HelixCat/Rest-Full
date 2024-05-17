package com.mahdi.restfullapi.controller;

import com.mahdi.restfullapi.dto.ProductDTO;
import com.mahdi.restfullapi.dto.ProductRecordDTO;
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
    public ResponseEntity<ProductRecordDTO> addProduct(@RequestBody ProductRecordDTO productRecordDTO) {
        ProductRecordDTO savedProduct = productService.saveProduct(productRecordDTO);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }


    @GetMapping("/product")
    public ResponseEntity<ProductDTO> findProductById(@RequestParam(name = "productId") long productId) {
        ProductDTO productDTO = productService.getProduct(productId);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }


    @GetMapping("/products")
    public List<ProductDTO> findAllProduct() {
        return productService.getProducts();
    }


    @PatchMapping("/product")
    public ResponseEntity<ProductDTO> updateProductById(@RequestParam(name ="productId") long productId, @RequestBody Product product) {
        ProductDTO updatedProduct = productService.updateProduct(productId, product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }


    @DeleteMapping("/product")
    public ResponseEntity<ProductDTO> deleteProductById(@RequestParam(name ="productId") long productId) {
        ProductDTO deletedProductDTO = productService.deletedProduct(productId);
        return new ResponseEntity<>(deletedProductDTO, HttpStatus.OK);
    }


    @GetMapping("/product")
    public ResponseEntity<ProductDTO> getProductsByName(@RequestParam(name ="productName") String productName) {
        ProductDTO productDTO = productService.getProductsByName(productName);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }
}
