package com.product.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Product {

    @Id
    private Long id;

    private String name;

    private Double price;

    private String description;

    private String imageUrl;

}
