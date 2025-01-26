package com.product.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.api.entity.Product;
import com.product.api.service.ProductService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/products")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {

        log.info("Inside ProductController === getAllProducts()");

        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("{id}") 
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        log.info("Inside ProductController === getProductById()");

        if (null == id) {
            throw new RuntimeException("Product id is not provided");
        }

        return ResponseEntity.ok(productService.getProductById(id));
    }

}
