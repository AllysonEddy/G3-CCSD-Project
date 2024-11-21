package com.example.ccsd.WebsiteTexts;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
