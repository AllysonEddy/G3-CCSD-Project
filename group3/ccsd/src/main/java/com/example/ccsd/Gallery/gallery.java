package com.example.ccsd.Gallery;

public class gallery {
    private String logo;
    private String description;
    private String image;
    private String title;
    private String text;

    public gallery(String logo, String description, String image, String title, String text) {
        this.logo = logo;
        this.description = description;
        this.image = image;
        this.title = title;
        this.text = text;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}