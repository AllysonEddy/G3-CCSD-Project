package com.example.ccsd.WebsiteImages;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "website_images")
public class WebsiteImages {
    @Id
    private String id;
    private String itemImages;
    private Date uploadDate;
    private String tags;

    public WebsiteImages (){} //
    public WebsiteImages (String itemImage, Date uploadDate, String tags) {
        this.itemImages = itemImage;
        this.uploadDate = uploadDate;
        this.tags = tags;
    }
    public String getId (){
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getItemImages() {
        return this.itemImages;
    }
    public void setItemImages(String itemImages) {
        this.itemImages = itemImages;
    }
    public Date uploadDate() {
        return this.uploadDate;
    }
    public void setuploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }
    public String gettags() {
        return this.tags;
    }
    public void settags(String tags) {
        this.tags = tags;
    }
}
