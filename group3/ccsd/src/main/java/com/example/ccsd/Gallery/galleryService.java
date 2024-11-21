package com.example.ccsd.Gallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class galleryService {
    
    @Autowired
    private galleryRepo galleryRepo;

    // Getting all gallery
    public List<gallery> getAllGallery() {
        return galleryRepo.findAll();
    }

    // Getting single gallery
    public Optional<gallery> getGalleryBygalleryId(String galleryId) {
        return galleryRepo.findById(galleryId);
    }

    // Creating new data in repository

    public gallery addGallery(gallery gallery) {
        return galleryRepo.save(gallery);
    }


    // Deleting
    
    public void deleteGallery(String galleryId) {
        galleryRepo.deleteById(galleryId);
    }
}
