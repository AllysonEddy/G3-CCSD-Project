package com.example.ccsd.Users;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<users> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<users> getUserID(String id){
        return userRepository.findById(id);
    }

    public Optional<users> getUserByEmail(String userEmail){
        return userRepository.findById(userEmail);
    }

    public users addUsers(users users){
        return userRepository.save(users);
    }

    public void deleteUser(String userEmail){
        userRepository.deleteById(userEmail);
    }

    public String saveuserImageToStorage(String uploadDirectory, MultipartFile imageFile) throws IOException {
        String uniqueFileName = UUID.randomUUID().toString() + "_" + imageFile.getOriginalFilename();
    
        Path uploadPath = Path.of(uploadDirectory);
        Path filePath = uploadPath.resolve(uniqueFileName);
    
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
    
        Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
    
        return uniqueFileName;  // Return the filename, which you can later use for linking
    }
    
    // To view an image
    public byte[] getuserImage(String imageDirectory, String imageName) throws IOException {
        Path imagePath = Path.of(imageDirectory, imageName);

        if (Files.exists(imagePath)) {
            byte[] imageBytes = Files.readAllBytes(imagePath);
            return imageBytes;
        } else {
            return null; // Handle missing images
        }
    }

    // Delete an image
    public String deleteuserImage(String imageDirectory, String imageName) throws IOException {
        Path imagePath = Path.of(imageDirectory, imageName);

        if (Files.exists(imagePath)) {
            Files.delete(imagePath);
            return "Success";
        } else {
            return "Failed"; // Handle missing images
        }
    }

}
