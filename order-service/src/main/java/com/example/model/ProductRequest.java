package com.example.model;

import lombok.Data;
import lombok.Builder;

import java.util.List;

@Data
@Builder
public class ProductRequest {
    private List<Product> products;
    private Long orderId;
}
