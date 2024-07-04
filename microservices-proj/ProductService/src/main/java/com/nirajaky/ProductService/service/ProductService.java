package com.nirajaky.ProductService.service;

import com.nirajaky.ProductService.model.ProductRequest;
import com.nirajaky.ProductService.model.ProductResponse;
import org.springframework.http.HttpStatusCode;

public interface ProductService {
    long saveProduct(ProductRequest productRequest);

    ProductResponse getProductByID(long productID);

    void reduceQuantity(long productId, long quantity);
}
