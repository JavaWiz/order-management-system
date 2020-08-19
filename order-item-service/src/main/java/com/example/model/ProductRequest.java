package com.example.model;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ProductRequest {
    @NotEmpty
    @NotNull
    private List<Product> products;
    private Long orderId;
}
