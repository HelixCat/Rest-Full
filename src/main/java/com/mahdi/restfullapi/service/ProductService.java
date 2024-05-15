package com.mahdi.restfullapi.service;

import com.mahdi.restfullapi.dto.ProductDTO;
import com.mahdi.restfullapi.exception.BusinessException;
import com.mahdi.restfullapi.model.Product;
import com.mahdi.restfullapi.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }


    public ProductDTO saveProduct(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        return modelMapper.map(productRepository.save(product), ProductDTO.class);
    }


    public ProductDTO getProduct(long productId) {
        try {
            Product product = productRepository.findById(productId).orElse(null);
            return modelMapper.map(product, ProductDTO.class);
        } catch (RuntimeException ex) {
            throw new BusinessException("Not Found" , ex);
        }
    }


    public List<ProductDTO> getProducts() {
        return productRepository.findAll().stream().map(product -> modelMapper.map(product, ProductDTO.class)).collect(Collectors.toList());
    }


    public ProductDTO updateProduct(long productId, Product product) {
        try {
            Product existingProduct = productRepository.findById(productId).orElse(null);
            if (Objects.nonNull(existingProduct)) {
                existingProduct.setName(product.getName());
                existingProduct.setColor(product.getColor());
                existingProduct.setPrice(product.getPrice());
                existingProduct.setExist(product.getExist());
                productRepository.save(existingProduct);
            }
            return modelMapper.map(existingProduct, ProductDTO.class);
        } catch (RuntimeException ex) {
            throw new BusinessException("Not Found", ex);
        }
    }


    public ProductDTO deletedProduct(long productId) {
        try {
            Product existingProduct = productRepository.findById(productId).orElse(null);
            ProductDTO deletedProductDTO = modelMapper.map(existingProduct, ProductDTO.class);
            productRepository.deleteById(productId);
            return deletedProductDTO;
        } catch (RuntimeException ex) {
            throw new BusinessException("Not Found", ex);
        }
    }


    public ProductDTO getProductsByName(String productName) {
        Product product = productRepository.getProductsByName(productName);
        return modelMapper.map(product, ProductDTO.class);
    }
}
