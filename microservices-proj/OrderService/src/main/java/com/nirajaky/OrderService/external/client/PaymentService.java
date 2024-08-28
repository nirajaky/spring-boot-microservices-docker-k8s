package com.nirajaky.OrderService.external.client;

import com.nirajaky.OrderService.exception.CustomException;
import com.nirajaky.OrderService.external.request.PaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@CircuitBreaker(name = "external", fallbackMethod = "fallback")
@FeignClient(name = "PAYMENT-SERVICE/payment")
public interface PaymentService {

    @PostMapping
    public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest);

//    default ResponseEntity<Long> fallback(Exception e) {
//        throw new CustomException("Payment Service is not available",
//                "UNAVAILABLE",
//                500);
//    }
}
