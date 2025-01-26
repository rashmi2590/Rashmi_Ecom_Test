package com.order.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order.api.entity.Order;
import com.order.api.entity.Product;
import com.order.api.repository.OrderRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Order createOrder(Order order) {

        // getting product details from product service
        if (null == order.getProducts()) {
            throw new RuntimeException("Products list is null");
        }

        for (Long productId : order.getProducts()) {
            try {
                ResponseEntity<Product> response = restTemplate.exchange(
                        "http://localhost:8080/api/products/" + productId,
                        HttpMethod.GET, null, Product.class);

                if (!response.getStatusCode().is2xxSuccessful()) {
                    log.error("Error while getting Product ", productId);
                } else {
                    log.info("Successfully getting product details", response.getBody().getId());
                }
            } catch (Exception e) {
                throw new RuntimeException("Internal server error" + e.getMessage());
            }

        }

        return orderRepository.save(order);

    }

}
