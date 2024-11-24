package com.example.ccsd.WebsiteImages;


import java.io.IOException;
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
@RequestMapping("/api/websiteimages")
public class WebImageController {

    @Autowired
    private WebImageService webImageService;

    // Get all images
    @GetMapping
    public List<WebsiteImages> getAllImages() {
        return webImageService.getAllImages();
    }

    // Get a single image by ID
    @GetMapping("/{id}")
    public ResponseEntity<WebsiteImages> getImageById(@PathVariable String id) {
        return webImageService.getImageById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Add a new image
    @PostMapping
    public ResponseEntity<WebsiteImages> addImage(@RequestBody WebsiteImages newImage) throws IOException {
        return ResponseEntity.ok(webImageService.addNewImage(newImage));
    }

    // Update an existing image
    @PutMapping("/{id}")
    public ResponseEntity<WebsiteImages> updateImage(@PathVariable String id, @RequestBody WebsiteImages imageDetails) {
        WebsiteImages updatedImage = webImageService.updateImage(id, imageDetails);
        return ResponseEntity.ok(updatedImage);
    }

    // Delete an image
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable String id) {
        webImageService.deleteImage(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/file/{id}")
    public ResponseEntity<WebsiteImages> getFile(@PathVariable String id) {
        return webImageService.getImageById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
