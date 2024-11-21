package com.example.ccsd.Products;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Product")
public class Product {
    @Id
    private String id;
    private String drinks;
    private Double drinksPrice;
    private String drinksDesc;
    // private String specialItems;
    // private String specialItemsDesc;

    public Product(){
        
    }

    public Product(String drinks, Double drinksPrice, String drinksDesc) {
        this.drinks = drinks;
        this.drinksPrice = drinksPrice;
        this.drinksDesc = drinksDesc;
        // this.specialItems = specialItems;
        // this.specialItemsDesc = specialItemsDesc;
    }

    //getter
    public String getIdDrinks() {
        return id;
    }

    public String getDrinks() {
        return drinks;
    }

    public Double getDrinksPrice() {
        return drinksPrice;
    }

    public String getDrinksDesc(){
        return drinksDesc;
    }



    // public String getSpecialItems(){
    //     return specialItems;
    // }
    
    // public String getSpecialItemsDesc(){
    //     return specialItemsDesc;
    // }

    //Setter
    public void getIdDrinks(String id) {
        this.id = id;
    }

    public void setDrinks(String drinks) {
        this.drinks = drinks;
    }


    public void setDrinksPrice(Double drinksPrice) {
        this.drinksPrice = drinksPrice;
    }

    public void setDrinksDesc(String drinksDesc){
        this.drinksDesc = drinksDesc;
    }

    // public void setSpecialItems(String specialItems) {
    //     this.specialItems = specialItems;
    // }

    // public void setSpecialItemsDesc(String specialItemsDesc) {
    //     this.specialItemsDesc = specialItemsDesc;
 //   }


}
