package com.product.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.api.entity.Product;
import com.product.api.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        try {
            return productRepository.findAll();
        } catch (Exception e) {
            log.error("error while fetching products" + e.getMessage());
            throw new RuntimeException("Internal Server Error while getting all Product");
        }
    }

    @Override
    public Product getProductById(Long productId) {
        try {
            return productRepository.findById(productId)
                    .orElseThrow(() -> new RuntimeException("Prduct not found with id:" + productId));
        } catch (Exception e) {
            log.error("error while fetching product by id" + e.getMessage());
            throw new RuntimeException("Internal Server Error while getting Product by id" + productId);

        }
    }

}
