package com.example.ccsd.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
