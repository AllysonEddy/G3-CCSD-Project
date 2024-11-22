package com.example.ccsd.Products;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    // Getting all products
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    // Getting single boks
    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    // Creating new data in repository

    public Product addProduct(Product products) {
        return productRepository.save(products);
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

}