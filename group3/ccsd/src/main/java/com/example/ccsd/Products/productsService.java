package com.example.ccsd.Products;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {
    
    @Autowired
    private ProductsRepository productsRepository;

}