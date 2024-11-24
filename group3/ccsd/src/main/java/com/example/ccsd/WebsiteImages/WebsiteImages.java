package com.example.ccsd.WebsiteImages;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "websiteimages")
public class WebsiteImages {
    @Id
    private String id;
    private String imageTitle;
    private String tags;
    private String postSlug;
    private Integer imageStatus;
    private Date uploadDate;
    private Boolean openAiImage;
    private Integer imagePlace;

    // Default constructor
    public WebsiteImages() {
        this.openAiImage = false; // Set default value
        this.uploadDate = new Date(); // Set default value
    }

    // Parameterized constructor
    public WebsiteImages(String id, String imageTitle, String tags, String postSlug, Integer imageStatus, Date uploadDate, Boolean openAiImage, Integer imagePlace) {
        this.id = id;
        this.imageTitle = imageTitle;
        this.tags = tags;
        this.postSlug = postSlug;
        this.uploadDate = uploadDate;
        this.imageStatus = imageStatus;
        this.openAiImage = openAiImage;
        this.imagePlace = imagePlace;
    }

    // Getters and setters
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageTitle() {
        return this.imageTitle;
    }
    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }
    public String getTags() {
        return this.tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Date getUploadDate() {
        return this.uploadDate != null ? new Date(this.uploadDate.getTime()) : null;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate != null ? new Date(uploadDate.getTime()) : null;
    }

    public String getPostSlug() {
        return this.postSlug;
    }

    public void setPostSlug(String postSlug) {
        this.postSlug = postSlug;
    }

    public Integer getImageStatus() {
        return this.imageStatus;
    }

    public void setImageStatus(Integer imageStatus) {
        this.imageStatus = imageStatus;
    }

    public Boolean getOpenAiImage() {
        return this.openAiImage;
    }

    public void setOpenAiImage(Boolean openAiImage) {
        this.openAiImage = openAiImage;
    }

    public Integer getImagePlace() {
        return this.imagePlace;
    }

    public void setImagePlace(Integer imagePlace) {
        this.imagePlace = imagePlace;
    }
}
