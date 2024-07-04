package com.nirajaky.ProductService.service;

import com.nirajaky.ProductService.entities.Product;
import com.nirajaky.ProductService.exception.ProductServiceCustomException;
import com.nirajaky.ProductService.model.ProductRequest;
import com.nirajaky.ProductService.model.ProductResponse;
import com.nirajaky.ProductService.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.*;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

    // private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Override
    public long saveProduct(ProductRequest productRequest) {
        log.info("Adding Product ..");

        Product product = Product.builder()
                .productName(productRequest.getProductName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .build();

        productRepository.save(product);

        log.info("Product Created");
        return product.getProductId();
    }

    @Override
    public ProductResponse getProductByID(long productID) {
        log.info("Get the product with ID : {}", productID);

        Product product = productRepository.findById(productID)
                .orElseThrow(() -> new ProductServiceCustomException(
                        "Product with given ID does not exist",
                        "PRODUCT_NOT_FOUND"));
        ProductResponse productResponse = new ProductResponse();

        copyProperties(product, productResponse);

        return productResponse;
    }

    @Override
    public void reduceQuantity(long productId, long quantity) {
        log.info("Reduce the Quantity {} for product ID : {}", productId, quantity);

        Product product = productRepository.findById(productId)
                .orElseThrow(() ->
                        new ProductServiceCustomException(
                                "Product with given ID does not exist",
                                "PRODUCT_NOT_FOUND"));

        if (product.getQuantity() < quantity) {
            throw new ProductServiceCustomException(
                    "Product does not have suffecient quantity",
                    "INSUFFICIENT_QUANTITY"
            );
        }

        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);

        log.info("Product saved with updated quantity to {}", product.getQuantity());
    }


}
