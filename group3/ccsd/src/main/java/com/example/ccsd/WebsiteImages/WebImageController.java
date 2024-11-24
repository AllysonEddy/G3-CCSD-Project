package com.example.ccsd.WebsiteImages;


import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.client.gridfs.model.GridFSFile;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/websiteimages")
public class WebImageController {

    @Autowired
    private WebImageService webImageService;

    @Autowired
    private GridFsTemplate gridFsTemplate;

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

    public ResponseEntity<WebsiteImages> addImage(@RequestBody WebsiteImages newImage){
        return ResponseEntity.ok(webImageService.addNewImage(newImage));

    public ResponseEntity<WebsiteImages> addImage(
        @RequestParam("image") MultipartFile image,
        @RequestParam("title") String title,
        @RequestParam("tag") String tag,
        @RequestParam("place") String place,
        @RequestParam("status") String status,
        @RequestParam("date") String date
    ) {
        try {
            WebsiteImages newImage = new WebsiteImages();
            newImage.setTags(tag);
            newImage.setImagePlace(place);
            newImage.setImageStatus(status);
            newImage.setUploadDate(new Date());
            newImage.setOpenAiImage(false);
            
            WebsiteImages createdImage = webImageService.addNewImage(newImage, image);
            return ResponseEntity.ok(createdImage);
        } catch (IOException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }

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

    @GetMapping("/file/{fileId}")
    public ResponseEntity<byte[]> getFile(@PathVariable String fileId) {
        try {
            GridFSFile file = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(fileId)));
            GridFsResource resource = gridFsTemplate.getResource(file);
            return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getMetadata().getString("_contentType")))
                .body(IOUtils.toByteArray(resource.getInputStream()));
        } catch (IOException | IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
