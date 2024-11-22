package com.example.ccsd.WebsiteTexts;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "websitetext")
public class WebsiteTexts {
  @Id
  private String id;
  private String title;
  private String description;
  private int status; 

  // Constructors
  public WebsiteTexts() {}

  public WebsiteTexts(String title, String description, int status) {
    this.title = title;
    this.description = description;
    this.status = status;
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

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }
}
