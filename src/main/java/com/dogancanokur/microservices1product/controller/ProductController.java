package com.dogancanokur.microservices1product.controller;

import com.dogancanokur.microservices1product.model.Product;
import com.dogancanokur.microservices1product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/product") // pre-path
public class ProductController {
    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping // => api/product
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        return new ResponseEntity<>(service.saveProduct(product), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}") // => api/product/{id}
    public ResponseEntity<?> deleteProduct(@PathVariable(name = "id") Long productId) {
        service.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping // => api/product
    public ResponseEntity<?> getAllProducts() {
        return new ResponseEntity<>(service.findAllProduct(), HttpStatus.OK);
    }
}
