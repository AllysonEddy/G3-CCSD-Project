package com.example.ccsd.WebsiteImages;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "website_images")
public class WebsiteImages {
    @Id
    private String id;
    private List<String> foodImages;
    private List<String> drinkImages;
    private List<String> specialImages;

    public WebsiteImages (String foodImage, String drinkImage, String specialImage) {
        this.foodImages = new ArrayList<>();
        this.drinkImages = new ArrayList<>();
        this.specialImages = new ArrayList<>();
    }
    public String getId (){
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }

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
