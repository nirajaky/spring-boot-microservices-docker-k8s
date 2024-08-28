package com.nirajaky.OrderService.services;

import com.nirajaky.OrderService.model.OrderRequest;
import com.nirajaky.OrderService.model.OrderResponse;

public interface OrderService {
    Long placeOrder(OrderRequest orderRequest);

    OrderResponse getOrderDetails(long orderId);
}
