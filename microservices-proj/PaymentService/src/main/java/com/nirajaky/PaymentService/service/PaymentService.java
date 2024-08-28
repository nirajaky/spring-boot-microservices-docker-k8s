package com.nirajaky.PaymentService.service;

import com.nirajaky.PaymentService.model.PaymentRequest;
import com.nirajaky.PaymentService.model.PaymentResponse;

public interface PaymentService {
    long doPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentDetailsByOrderId(String orderId);
}
