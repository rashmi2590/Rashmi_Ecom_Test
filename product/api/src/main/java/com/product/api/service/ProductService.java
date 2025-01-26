package com.product.api.service;

import java.util.List;

import com.product.api.entity.Product;

public interface ProductService {

    /** Get All Products */
    public List<Product> getAllProducts();

    /* get product by product id */
    public Product getProductById(Long productId);

}
