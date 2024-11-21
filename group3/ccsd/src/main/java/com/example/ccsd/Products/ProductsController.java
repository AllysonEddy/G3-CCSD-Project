package com.example.ccsd.Products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/products")
public class ProductsController {
    
    @Autowired
    private productsService productsService;

    @GetMapping("/drinks")
    public List<products> getAllDrinks(){
        return productsService.getAllDrinks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<products> getDrinksById(@PathVariable String id) {
        return productsService.getDrinksById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public products addDrinks(@RequestBody products products) {
        return productsService.addDrinks(products);
    }
}
