package com.micro.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.micro.dto.ProductRequest;
import com.micro.entities.Product;
import com.micro.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest product){
        Product savedProduct = productRepository.save(Product.builder()
        .name(product.getName())
        .description(product.getDescription())
        .price(product.getPrice())
        .build());
        log.info("Product {} is saved",savedProduct.getId());
    }

    public List<Product> findAllproducts(){
        return productRepository.findAll();
    }

}