package com.nirajaky.OrderService.services;

import com.nirajaky.OrderService.entities.Order;
import com.nirajaky.OrderService.external.client.ProductService;
import com.nirajaky.OrderService.model.OrderRequest;
import com.nirajaky.OrderService.repositories.OrderRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    @Override
    public Long placeOrder(OrderRequest orderRequest) {

        // OrderEntity -> Save the data with Status Order Created
        // ProductService -> Block Product (Reduce the quantity)
        // PaymentService -> Payments -> Success -> COMPLETED , ELSE -> CANCELLED


        // Different error response like 404 or 500 etc. will have to be handled through CustomErrorDecoder
        // ErrorDecoder is part of Feign - means error messages can also be communicated through Feign
        productService.reduceQuantity(orderRequest.getProductId(), orderRequest.getQuantity());

        log.info("Placing order with request {}", orderRequest);
        Order order = Order.builder()
                .amount(orderRequest.getTotalAmount())
                .orderStatus("CREATED")
                .productId(orderRequest.getProductId())
                .orderDate(Instant.now())
                .quantity(orderRequest.getQuantity()).build();

        log.info("Order saved with Status CREATED");
        order = orderRepository.save(order);
        return order.getId();
    }
}
