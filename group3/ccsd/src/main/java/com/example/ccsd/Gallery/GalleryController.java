package com.example.ccsd.Gallery;
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
@RequestMapping("/api/gallery")
public class galleryController {
    @Autowired
    private galleryService galleryService;

    @GetMapping
    public List<gallery> getAllGallery() {
        return galleryService.getAllGallery();
    }

    @GetMapping("/{id}")
    public ResponseEntity<gallery> getGalleryById(@PathVariable String galleryId) {
        return galleryService.getGalleryBygalleryId(galleryId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public gallery addGallery(@RequestBody gallery gallery) {
        return galleryService.addGallery(gallery);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGallery(@PathVariable String galleryId) {
        galleryService.deleteGallery(galleryId);
        return ResponseEntity.noContent().build();
    }
}

