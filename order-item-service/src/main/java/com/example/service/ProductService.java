package com.example.service;

import com.example.entity.ProductEntity;
import com.example.model.ProductRequest;
import com.example.model.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse saveProducts(ProductRequest productRequest);
    ProductEntity getProduct(Long productId);
}
