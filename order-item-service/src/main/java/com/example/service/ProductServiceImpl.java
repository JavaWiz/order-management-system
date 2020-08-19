package com.example.service;

import com.example.entity.ProductEntity;
import com.example.exception.ProductNotFoundException;
import com.example.model.ProductRequest;
import com.example.model.ProductResponse;
import com.example.repository.ProductRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Validated
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductResponse saveProducts(@NonNull ProductRequest productRequest) {
        List<ProductEntity> products = productRequest.getProducts().stream()
                .map(pr -> ProductEntity.builder()
                        .productCode(pr.getProductCode())
                        .productName(pr.getProductName())
                        .quantity(pr.getQuantity())
                        .orderId(productRequest.getOrderId())
                .build()).collect(Collectors.toList());
        List<Long> id = productRepository.saveAll(products)
                .stream().map(ProductEntity::getOrderId)
                .collect(Collectors.toList());
        return ProductResponse.builder().message("Order save with order ids: "+id).build();
    }

    @Override
    public ProductEntity getProduct(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Could not find a product with product id :"+productId));
    }
}
