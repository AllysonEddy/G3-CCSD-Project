package com.example.ccsd.Products;

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
    private String productStatus;
    private String productTags;
    private int productPlace;
    private String productDesc;
    private String productFile;
    private Long productLongDesc;


    public Product(){
        
    }

    public Product(String productTitle, String productSlug, Date productPublishDate, String productStatus, String productTags, int productPlace, String productDesc, String productFile, Long productLongDesc) {
        this.productTitle = productTitle;
        this.productSlug = productSlug;
        this.productPublishDate = productPublishDate;
        this.productStatus = productStatus;
        this.productTags = productTags;
        this.productPlace = productPlace;
        this.productDesc = productDesc;
        this.productFile = productFile;
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

    public String getProductStatus(){
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

    public String getProductFile(){
        return productFile;
    }

    public Long getProductLongDesc(){
        return productLongDesc;
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

    public void setProductStatus(String productStatus){ 
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

    public void setProductFile(String productFile){ 
        this.productFile = productFile;
    }

    public void setProductLongDesc(Long productLongDesc){ 
        this.productLongDesc = productLongDesc;
    }


}
