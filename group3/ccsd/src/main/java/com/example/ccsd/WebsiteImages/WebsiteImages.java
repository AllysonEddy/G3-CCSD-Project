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

    // Default constructor
    public WebsiteImages() {}

    // Parameterized constructor
    public WebsiteImages(String id, String itemImages, Date uploadDate, String tags) {
        this.id = id;
        this.itemImages = itemImages;
        this.uploadDate = uploadDate;
        this.tags = tags;
    }

    // Getters and setters
    public String getId() {
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

    public Date getUploadDate() {
        // Return a defensive copy to prevent external modification
        return this.uploadDate != null ? new Date(this.uploadDate.getTime()) : null;
    }

    public void setUploadDate(Date uploadDate) {
        // Use a defensive copy to prevent external modification
        this.uploadDate = uploadDate != null ? new Date(uploadDate.getTime()) : null;
    }

    public String getTags() {
        return this.tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
