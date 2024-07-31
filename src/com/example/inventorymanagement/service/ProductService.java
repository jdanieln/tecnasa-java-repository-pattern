package com.example.inventorymanagement.service;

import com.example.inventorymanagement.model.Product;
import com.example.inventorymanagement.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(String name, double price) {
        Product newProduct = new Product(null, name, price);
        return productRepository.save(newProduct);
    }
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
    public Product updateProductById(Long id, String name, double price) {
        Product updatedProduct = new Product(id, name, price);
        return productRepository.save(updatedProduct);
    }
}
