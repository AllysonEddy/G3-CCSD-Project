package com.example.ccsd.Products;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {
    
    @Autowired
    private ProductsRepository productsRepository;

    // Getting all books
    public List<products> getAllDrinks() {
        return productsRepository.findAll();
    }

    // Getting single boks
    public Optional<products> getDrinksById(String id) {
        return productsRepository.findById(id);
    }

    // Creating new data in repository

    public products addDrinks(products products) {
        return productsRepository.save(products);
    }

    public void deleteDrinks(String id) {
        productsRepository.deleteById(id);
    }

}