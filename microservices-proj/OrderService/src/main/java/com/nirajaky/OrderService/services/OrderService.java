package com.nirajaky.OrderService.services;

import com.nirajaky.OrderService.model.OrderRequest;

public interface OrderService {
    Long placeOrder(OrderRequest orderRequest);
}
