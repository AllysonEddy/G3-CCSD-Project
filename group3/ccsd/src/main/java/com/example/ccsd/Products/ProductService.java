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
    public List<Product> getAllDrinks() {
        return productRepository.findAll();
    }

    // Getting single boks
    public Optional<Product> getDrinksById(String id) {
        return productRepository.findById(id);
    }

    // Creating new data in repository

    public Product addDrinks(Product products) {
        return productRepository.save(products);
    }

    public void deleteDrinks(String id) {
        productRepository.deleteById(id);
    }

}