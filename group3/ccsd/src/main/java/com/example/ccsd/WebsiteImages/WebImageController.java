package com.example.ccsd.WebsiteImages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/webimages")
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
    public ResponseEntity<WebsiteImages> addImage(@RequestBody WebsiteImages newImage) {
        WebsiteImages createdImage = webImageService.addNewImage(newImage);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdImage.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdImage);
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
}
