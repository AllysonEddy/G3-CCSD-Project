package com.example.ccsd.Products;

public class products {
    private String drinks;
    private Double drinksPrice;
    private String drinksDesc;
    private String specialItems;
    private String specialItemsDesc;

    public products(String drinks, Double drinksPrice, String drinksDesc, String specialItems, String specialItemsDesc) {
        this.drinks = drinks;
        this.drinksPrice = drinksPrice;
        this.drinksDesc = drinksDesc;
        this.specialItems = specialItems;
        this.specialItemsDesc = specialItemsDesc;
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



    public String getSpecialItems(){
        return specialItems;
    }
    
    public String getSpecialItemsDesc(){
        return specialItemsDesc;
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

    public void setSpecialItems(String specialItems) {
        this.specialItems = specialItems;
    }

    public void setSpecialItemsDesc(String specialItemsDesc) {
        this.specialItemsDesc = specialItemsDesc;
    }


    public static void main(String[] args) {

        products p = new products("0", 0.00, "drinksDesc", "specialItems", "specialItemsDesc");
        p.setDrinks("Coke");
        p.setDrinksPrice(1.5);
        p.setDrinksDesc("A refreshing and popular choice.");
        p.setSpecialItems("Soda");
        p.setSpecialItemsDesc("A popular choice for those looking to enjoy a refreshing drink.");

        System.out.println("\n" + p.getDrinks() + "\n" + p.getDrinksPrice() + "\n" + p.getDrinksDesc() + "\n");
    }
}
