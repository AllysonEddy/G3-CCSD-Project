package com.example.ccsd.WebsiteImages;
    
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
    
import java.util.*;
    
 @Service
public class WebImageService {
        
    @Autowired
    private WebImageRepository webImageRepository;
    
        // Getting all images
        public List<WebsiteImages> getAllImages() {
            return webImageRepository.findAll();
        }
    
        // Getting single image
        public Optional<WebsiteImages> getImageById(String id) {
            return webImageRepository.findById(id);
        }
    
        // Creating new image in repository
    
        public WebsiteImages addNewImage(WebsiteImages newImage) {
            return webImageRepository.save(newImage);
        }
    
        // Updating the image
    
        // public WebImage updateImage(String id, WebImage imageDetails) {
        //     Optional<WebImage> imageOpt = WebImageRepository.findById(id);
        //     if (imageOpt.isPresent()) {
    
        //         // Get from database
    
        //         WebImage book = bookOpt.get();
        //         book.setTitle(bookDetails.getTitle());
        //         book.setAuthor(bookDetails.getAuthor());
        //         book.setIsbn(bookDetails.getIsbn());
        //         book.setAvailable(bookDetails.isAvailable());
        //         return bookRepository.save(book);
        //     }
        //     return null;
        // }
    
        // Deleting
        
        public void deleteImage(String id) {
            webImageRepository.deleteById(id);
        }
    }
