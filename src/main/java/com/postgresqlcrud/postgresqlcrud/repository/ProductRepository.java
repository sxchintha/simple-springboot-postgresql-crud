package com.postgresqlcrud.postgresqlcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postgresqlcrud.postgresqlcrud.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
        
}
