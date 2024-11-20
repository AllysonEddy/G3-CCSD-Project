package com.example.ccsd.WebsiteImages;

import java.util.List;

public class WebsiteImages {
    private List<String> foodImages;   // Store multiple image paths for food
    private List<String> drinkImages; // Store multiple image paths for drinks
    private List<String> specialImages; // Store multiple image paths for specials

    public List<String> getFoodImages() {
        return this.foodImages;
    }
    public void setFoodImages(List<String> foodImages) {
        this.foodImages = foodImages;
    }

    public List<String> getDrinkImages() {
        return this.drinkImages;
    }
    public void setDrinkImages(List<String> drinkImages) {
        this.drinkImages = drinkImages;
    }

    public List<String> getSpecialImages() {
        return this.specialImages;
    }
    public void setSpecialImages(List<String> specialImages) {
        this.specialImages = specialImages;
    }
}
