package com.example.ccsd.WebsiteTexts;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "websitetext")
public class WebsiteTexts {
  private String description;
  private String title;

  //Constructors
  public WebsiteTexts() {}

  public WebsiteTexts(String title, String description) {
    this.title = title;
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
