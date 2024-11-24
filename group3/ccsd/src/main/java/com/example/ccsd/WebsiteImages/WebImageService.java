package com.example.ccsd.WebsiteImages;


import java.io.IOException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;


@Service
public class WebImageService {

    @Autowired
    private WebImageRepository webImageRepository;

    @Autowired
    private GridFsTemplate gridFsTemplate;

    // Get all images
    public List<WebsiteImages> getAllImages() {
        return webImageRepository.findAll();
    }

    public Optional<WebsiteImages> getImageById(String id) {
        return webImageRepository.findById(id);
    }

    // Create a new image

    public WebsiteImages addNewImage(WebsiteImages newImage, MultipartFile file) throws IOException {
        String fileId = storeFile(file);
        newImage.setFileId(fileId);
        newImage.setFileName(file.getOriginalFilename());
        newImage.setContentType(file.getContentType());

        return webImageRepository.save(newImage);
    }

    // Update an existing image
    public WebsiteImages updateImage(String id, WebsiteImages imageDetails) {
        Optional<WebsiteImages> imageOpt = webImageRepository.findById(id);
        if (imageOpt.isPresent()) {
            WebsiteImages existingImage = imageOpt.get();

            // Update fields

            existingImage.setImagePath(imageDetails.getImagePath());

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

        WebsiteImages image = webImageRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Image not found"));
        gridFsTemplate.delete(Query.query(Criteria.where("_id").is(image.getFileId())));

        webImageRepository.deleteById(id);
    }

    // Add new method to store file
    public String storeFile(MultipartFile file) throws IOException {
        return gridFsTemplate.store(
            file.getInputStream(),
            file.getOriginalFilename(),
            file.getContentType()
        ).toString();
    }
}
