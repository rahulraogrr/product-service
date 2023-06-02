package com.micro.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.micro.entities.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    
}
