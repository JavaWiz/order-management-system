package com.example.service;

import com.example.model.ProductRequest;
import com.example.model.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "ProductServer", url = "http://localhost:1111")
public interface ProductService {

    @PostMapping(value = "api/products/create")
    ProductResponse saveProducts(@RequestBody ProductRequest products);
}
