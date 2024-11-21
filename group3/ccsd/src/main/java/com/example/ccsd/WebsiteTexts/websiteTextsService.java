package com.example.ccsd.WebsiteTexts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class websiteTextsService {

  @Autowired
    private websitetextsRepository websitetextRepository;

    // Getting all websiteText
    public List<WebsiteTexts> getAllwebsiteTexts() {
      return websitetextRepository.findAll();
    }


    // Gettin single websiteText
    public Optional<WebsiteTexts> getwebsiteTextsByTitle(String title) {
      return websitetextRepository.findByTitle(title);
    }

    // Creating new data in repository
    public WebsiteTexts addwebsiteTexts(WebsiteTexts websiteTexts) {
      return websitetextRepository.save(websiteTexts)
    }
}
