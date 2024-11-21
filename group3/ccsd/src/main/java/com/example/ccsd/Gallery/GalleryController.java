package com.example.ccsd.Gallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gallery")
public class GalleryController {
    @Autowired
    private GalleryService galleryService;

    @GetMapping
    public List<gallery> getAllGallery() {
        return galleryService.getAllGallery();
    }

    @GetMapping("/{id}")
    public ResponseEntity<gallery> getGalleryById(@PathVariable int id) {
        return galleryService.getGalleryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public gallery addGallery(@RequestBody gallery gallery) {
        return galleryService.addGallery(gallery);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGallery(@PathVariable int id) {
        galleryService.deleteGallery(id);
        return ResponseEntity.noContent().build();
    }
}

