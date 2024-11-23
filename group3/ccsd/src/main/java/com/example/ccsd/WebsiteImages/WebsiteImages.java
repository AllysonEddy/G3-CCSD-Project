package com.example.ccsd.WebsiteImages;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "website_images")
public class WebsiteImages {
    @Id
    private String id;
    private String itemImages;
    private String tags;
    private String postSlug;
    private String imageStatus;
    private Date uploadDate;
    private Boolean openAiImage ;
    private String imagePlace;
    private String imageDesc;

    // Parameterized constructor
    public WebsiteImages(String id, String itemImages, String tags,String postSlug,String imageStatus, Date uploadDate,Boolean openAiImage,String imagePlace,String imageDesc) {
        this.id = id;
        this.itemImages = itemImages;
        this.tags = tags;
        this.postSlug = postSlug;
        this.uploadDate = uploadDate;
        this.imageStatus = imageStatus;
        this.openAiImage = openAiImage;
        this.imagePlace =imagePlace;
        this.imageDesc = imageDesc;
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
    public String getTags() {
        return this.tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Date getUploadDate() {
        // Return a defensive copy to prevent external modification
        return this.uploadDate != null ? new Date(this.uploadDate.getTime()) : null;
    }

    public void setUploadDate(Date uploadDate) {
        // Use a defensive copy to prevent external modification
        this.uploadDate = uploadDate != null ? new Date(uploadDate.getTime()) : null;
    }
    public String getPostSlug() {
        return this.postSlug;
    }

    public void setPostSlug(String postSlug) {
        this.postSlug = postSlug;
    }
    public String getImageStatus() {
        return this.imageStatus;
    }

    public void setImageStatus(String imageStatus) {
        this.imageStatus = imageStatus;
    }
    public Boolean getOpenAiImage(){
        return this.openAiImage;
    }
    public void setOpenAiImage (Boolean openAiImage){
        this.openAiImage = openAiImage;
    }
    public String getImagePlace(){
        return this.imagePlace ;
    }
    public void setImagePlace (String imagePlace){
        this.imagePlace =imagePlace;
    }
    public String getImageDesc(){
        return this.imageDesc ;
    }
    public void setImageDesc (String imageDesc){
        this.imageDesc =imageDesc;
    }

}
