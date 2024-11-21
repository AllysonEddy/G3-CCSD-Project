package com.example.ccsd.WebsiteImages;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/webimages")
public class WebImageController {
    
    @Autowired
    private WebImageService webImageService;

    @GetMapping
    public List<WebsiteImages> getAllImage() {
        return webImageService.getAllImages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WebsiteImages> getImageById(@PathVariable String id) {
        return webImageService.getImageById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public WebsiteImages addImage(@RequestBody WebsiteImages newImage) {
        return webImageService.addNewImage(newImage);
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<WebsiteImages> updateImage(@PathVariable String id, @RequestBody WebsiteImages imageDetails) {
    //     WebsiteImages updatedImage = webImageService.updateImage(id, imageDetails);
    //     if (updatedImage != null) {
    //         return ResponseEntity.ok(updatedImage);
    //     }
    //     return ResponseEntity.notFound().build();
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable String id) {
        webImageService.deleteImage(id);
        return ResponseEntity.noContent().build();
    }
}

