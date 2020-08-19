package com.example.controller;


import com.example.entity.ProductEntity;
import com.example.model.ProductRequest;
import com.example.model.ProductResponse;
import com.example.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<ProductResponse> createProducts(@Valid @RequestBody ProductRequest productRequest){
        log.info("Order Request : {}", productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProducts(productRequest));
    }

    @GetMapping("/retrieve/{productId}")
    public ResponseEntity<ProductEntity> getProduct(@PathVariable Long productId){
        return ResponseEntity.ok(productService.getProduct(productId));
    }
}
