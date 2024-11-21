package com.example.ccsd.WebsiteTexts;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "websitetext")
public class WebsiteTexts {
  @Id
  private String id;
  private String description;
  private String title;
  private String content;


  //Constructors
  public WebsiteTexts() {}

  public WebsiteTexts(String title, String description, String content) {
    this.title = title;
    this.description = description;
    this.content = content;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
