package com.mahdi.restfullapi.service;

import com.mahdi.restfullapi.dto.ProductDTO;
import com.mahdi.restfullapi.model.Product;
import com.mahdi.restfullapi.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }


    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }


    public ProductDTO getProduct(long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Not Found Product"));
        return modelMapper.map(product, ProductDTO.class);
    }


    public List<Product> getProducts() {
        return productRepository.findAll();
    }


    public Product updateProduct(long productId, Product product) {
        Product existingProduct = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Not Found Product"));
        existingProduct.setName(product.getName());
        existingProduct.setColor(product.getColor());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setExist(product.getExist());
        productRepository.save(existingProduct);
        return existingProduct;
    }


    public Product deleteproduct(long productId) {
        Product existingProduct = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Not Found Product"));
        productRepository.deleteById(productId);
        return existingProduct;
    }


    public List<Product> getProductsByName(String productName) {
        return productRepository.getProductsByName(productName);
    }
}
