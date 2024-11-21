package com.example.ccsd.Products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/products")
public class ProductsController {
    
    @Autowired
    private ProductsService productsService;

    @GetMapping("/drinks")
    public List<Products> getAllDrinks(){
        return productsService.getAllDrinks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> getDrinksById(@PathVariable String id) {
        return productsService.getDrinksById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Products addDrinks(@RequestBody Products products) {
        return productsService.addDrinks(products);
    }
}
