package com.example.ccsd.Gallery;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Base64;
import java.util.Date;

@Document(collection = "gallery")
public class gallery {
    @Id
    private String id;
    private String title;
    private String description;
    private byte[] image; // The actual image stored as byte array
    private Date date;
    private String image64String; // To hold the base64 string

    public gallery() {}

    public gallery(String title, String description, byte[] image, Date date) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.date = date;
    }

    // Get the image as Base64 string (for sending to the frontend)
    public String getImageAsBase64() {
        return image != null ? Base64.getEncoder().encodeToString(image) : null;
    }

    // Set the base64 string representation of the image
    public void setImage64String(String image64String) {
        this.image64String = image64String;
    }

    public String getImage64String() {
        return this.image64String;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}