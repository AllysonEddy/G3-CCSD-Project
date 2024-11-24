package com.example.ccsd.Products;

import java.util.Base64;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Products")
public class Product {
    @Id
    private String id;
    private String productTitle;
    private String productSlug;
    private Date productPublishDate;
    private int productStatus;
    private String productTags;
    private int productPlace;
    private String productDesc;
    private byte[] productImage;
    private String productImage64String;
    private String productLongDesc;


    public Product(){
        
    }

    public Product(String productTitle, String productSlug, Date productPublishDate, 
                    int productStatus, String productTags, int productPlace, 
                    String productDesc, byte[] productImage, String productLongDesc) {
        this.productTitle = productTitle;
        this.productSlug = productSlug;
        this.productPublishDate = productPublishDate;
        this.productStatus = productStatus;
        this.productTags = productTags;
        this.productPlace = productPlace;
        this.productDesc = productDesc;
        this.productImage = productImage;
        this.productLongDesc = productLongDesc;

    }


    //getter
    public String getId() {
        return id;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public String getProductSlug() {
        return productSlug;
    }

    public Date getProductPublishDate(){
        return productPublishDate;
    }

    public int getProductStatus(){
        return productStatus;
    }

    public String getProductTags(){
        return productTags;
    }

    public int getProductPlace(){
        return productPlace;
    }

    public String getProductDesc(){
        return productDesc;
    }

    public String getProductLongDesc(){
        return productLongDesc;
    }

    public byte[] getProductImage() {
        return this.productImage;
    }



    public void setProductTitle(String productTitle){ 
        this.productTitle = productTitle;
    }


    public void setProductSlug(String productSlug){ 
        this.productSlug = productSlug;
    }

    public void setProductPublishDate(Date productPublishDate){
        this.productPublishDate = productPublishDate;
    }

    public void setProductStatus(int productStatus){ 
        this.productStatus = productStatus;
    }

    public void setProductTags(String productTags){ 
        this.productTags = productTags;
    }

    public void setProductPlace(int productPlace){ 
        this.productPlace = productPlace;
    }

        public void setProductDesc(String productDesc){ 
        this.productDesc = productDesc;
    }


    public void setProductLongDesc(String productLongDesc){ 
        this.productLongDesc = productLongDesc;
    }

    public void setProductImage(byte[] productImage) {
        this.productImage = productImage;
    }

    public String getImageAsBase64() {
        return productImage != null ? Base64.getEncoder().encodeToString(productImage) : null;
    }

    public void setProductImage64String(String productImage64String) {
        this.productImage64String = productImage64String;  // Set Base64 string
    }

    public String getProductImage64String() {
        return this.productImage64String;  // Return Base64 string
    }

}
