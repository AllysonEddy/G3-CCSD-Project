package com.example.ccsd.Gallery;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/gallery")
public class galleryControll {

    @Autowired
    private galleryService galleryService;

    // Fetch all galleries with base64 image encoding
    @GetMapping
    public List<gallery> getAllGallerys() {
        List<gallery> galleryList = galleryService.getAllGallery();
        return galleryList.stream()
            .map(gallery -> {
                gallery.setImage64String(gallery.getImageAsBase64());
                return gallery;
            })
            .collect(Collectors.toList());
    }

    // Fetch a single gallery by ID
    @GetMapping("/{id}")
    public ResponseEntity<gallery> getGalleryById(@PathVariable String id) {
        return galleryService.getGalleryById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // Add a new gallery item with image
    @PostMapping
    public gallery addGallery(
        @RequestParam("title") String title,
        @RequestParam("description") String description,
        @RequestParam("image") MultipartFile image) {
        
        try {
            // Convert image to byte array
            byte[] imageBytes = image.getBytes();
            
            // Create a new gallery object
            gallery newGallery = new gallery(title, description, imageBytes, new java.util.Date());
            
            // Save the gallery item
            return galleryService.addGallery(newGallery);
        } catch (Exception e) {
            throw new RuntimeException("Error saving gallery item: " + e.getMessage(), e);
        }
    }

    // Delete a gallery item by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGallery(@PathVariable String id) {
        galleryService.deleteGallery(id);
        return ResponseEntity.noContent().build();
    }
}
