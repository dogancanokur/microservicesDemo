package com.dogancanokur.microservices1product.service.impl;

import com.dogancanokur.microservices1product.model.Product;
import com.dogancanokur.microservices1product.repository.ProductRepository;
import com.dogancanokur.microservices1product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product saveProduct(Product product) {
        product.setCreateTime(LocalDateTime.now());
        return repository.save(product);
    }

    @Override
    public Product findAllProduct() {
        return repository.findAll();
    }

    @Override
    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }

}
