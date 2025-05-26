package com.mystore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mystore.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
