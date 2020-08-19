package com.example.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderRequest {
    @NotEmpty(message = "Please provide a name")
    private String customerName;
    @NotEmpty(message = "Please provide shippingAddress")
    private String shippingAddress;
    private List<Product> products;
    private BigDecimal orderTotal;
}
