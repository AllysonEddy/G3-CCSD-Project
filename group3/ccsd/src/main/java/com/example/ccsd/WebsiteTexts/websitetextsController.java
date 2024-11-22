package com.example.ccsd.WebsiteTexts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/websitetext")
public class websitetextsController {
  
  @Autowired
  private websiteTextsService websitetextsService;

  @GetMapping
  public List<WebsiteTexts> getAllwebsiteTexts() {
    return websitetextsService.getAllwebsiteTexts();
  }

  @GetMapping("/{id}")
  public ResponseEntity<WebsiteTexts> getwebsiteTextsById(@PathVariable String id) {
    return websitetextsService.getwebsiteTextsById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public WebsiteTexts addwebsiteTexts(@RequestBody WebsiteTexts websitetexts) {
    return websitetextsService.addwebsiteTexts(websitetexts);
  }
}
