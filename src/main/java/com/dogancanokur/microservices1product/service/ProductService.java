package com.dogancanokur.microservices1product.service;

import com.dogancanokur.microservices1product.model.Product;

public interface ProductService {
    Product saveProduct(Product product);

    Product findAllProduct();

    void deleteProduct(Long id);
}
