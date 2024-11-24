package com.example.ccsd.Gallery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class galleryService {

    @Autowired
    private galleryRepo galleryRepo; // Repository to interact with MongoDB

    // Fetch all gallery items
    public List<gallery> getAllGallery() {
        return galleryRepo.findAll();
    }

    // Fetch a specific gallery item by its ID
    public Optional<gallery> getGalleryById(String id) {
        return galleryRepo.findById(id);
    }

    // Add a new gallery item
    public gallery addGallery(gallery newGallery) {
        return galleryRepo.save(newGallery);
    }

    // Delete a gallery item by its ID
    public void deleteGallery(String id) {
        galleryRepo.deleteById(id);
    }
}
