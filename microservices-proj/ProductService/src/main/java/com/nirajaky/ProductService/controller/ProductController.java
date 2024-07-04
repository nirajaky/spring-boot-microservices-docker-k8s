package com.nirajaky.ProductService.controller;

import com.nirajaky.ProductService.model.ProductRequest;
import com.nirajaky.ProductService.model.ProductResponse;
import com.nirajaky.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest) {
        long productID = productService.saveProduct(productRequest);

        return new ResponseEntity<>(productID, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductByID(@PathVariable("id") long productID) {
        ProductResponse productResponse = productService.getProductByID(productID);

        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @GetMapping("/reduceQuantity/{id}")
    public ResponseEntity<Void> reduceQuantity(
            @PathVariable("id") long productId,
            @RequestParam long quantity
    ) {
        productService.reduceQuantity(productId, quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
