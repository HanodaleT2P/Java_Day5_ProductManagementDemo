package com.mystore.service;

import org.springframework.stereotype.Service;

import com.mystore.model.Product;
import com.mystore.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Create a new product
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get product by ID
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElse(null); // Return null if not found (can be handled in controller)
    }

    // Update product by ID
    public Product updateProduct(Long id, Product updatedProduct) {
        Product existingProduct = getProductById(id);
        if (existingProduct != null) {
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setQuantity(updatedProduct.getQuantity());
            return productRepository.save(existingProduct);
        }
        return null;
    }

    // Delete product by ID
    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        if (product != null) {
            productRepository.delete(product);
        }
    }
}
