package com.example.ccsd.WebsiteImages;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebImageService {

    @Autowired
    private WebImageRepository webImageRepository;

    // Get all images
    public List<WebsiteImages> getAllImages() {
        return webImageRepository.findAll();
    }

    public Optional<WebsiteImages> getImageById(String id) {
        return webImageRepository.findById(id);
    }

    // Create a new image
    public WebsiteImages addNewImage(WebsiteImages newImage) {
        return webImageRepository.save(newImage);
    }

    // Update an existing image
    public WebsiteImages updateImage(String id, WebsiteImages imageDetails) {
        Optional<WebsiteImages> imageOpt = webImageRepository.findById(id);
        if (imageOpt.isPresent()) {
            WebsiteImages existingImage = imageOpt.get();

            // Update fields
            existingImage.setTags(imageDetails.getTags());
            existingImage.setPostSlug(imageDetails.getPostSlug());
            existingImage.setImageStatus(imageDetails.getImageStatus());
            existingImage.setUploadDate(imageDetails.getUploadDate());
            existingImage.setOpenAiImage(imageDetails.getOpenAiImage());
            existingImage.setImagePlace(imageDetails.getImagePlace());

            return webImageRepository.save(existingImage);
        } else {
            throw new NoSuchElementException("Image with ID " + id + " not found.");
        }
    }

    // Delete an image
    public void deleteImage(String id) {
        webImageRepository.deleteById(id);
    }
}
