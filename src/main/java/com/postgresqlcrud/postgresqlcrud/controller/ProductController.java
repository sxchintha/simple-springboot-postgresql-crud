package com.postgresqlcrud.postgresqlcrud.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postgresqlcrud.postgresqlcrud.model.Product;
import com.postgresqlcrud.postgresqlcrud.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {
    
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllProducts() {
        return ResponseEntity.ok(this.productRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.productRepository.findById(id));
    }

    @PostMapping("")
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        System.out.println(product);
        return ResponseEntity.ok(this.productRepository.save(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody Product product) {
        Product productToUpdate = this.productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        productToUpdate.setName(product.getName());
        productToUpdate.setDescription(product.getDescription());
        return ResponseEntity.ok(this.productRepository.save(productToUpdate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        this.productRepository.deleteById(id);
        return ResponseEntity.ok("Product deleted");
    }

}
