package com.nirajaky.OrderService.repositories;

import com.nirajaky.OrderService.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
