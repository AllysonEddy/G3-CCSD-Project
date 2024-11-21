package com.example.ccsd.WebsiteTexts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/websitetext")
public class websiteTextsController {
  
  @Autowired
  private websiteTextsService websitetextsService;

  @GetMapping
  public List<websiteTexts> getAllwebsiteTexts() {
    return websitetextsService.getAllwebsiteTexts();
  }

  @GetMapping("/{title}")
  public ResponseEntity<websiteTexts> getwebsiteTextsByTitle(@PathVariable String title) {
    return websitetextsService.getwebsiteTextsByTitle(title)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public websiteTexts addwebsiteTexts(@RequestBody WebsiteTexts websitetexts) {
    return websiteTextsService.addwebsiteTexts(websitetexts);
  }
}
