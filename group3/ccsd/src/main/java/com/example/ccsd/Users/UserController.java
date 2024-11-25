package com.example.ccsd.Users;

import java.util.List;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping
    public List<users> getAllUsers(){
        List<users> usersList = userService.getAllUsers();
        return usersList.stream()
            .map(users -> {
                users.setUserImage64String(users.getUserImage64());
                return users;
            })
            .collect(Collectors.toList());
    }

     @GetMapping("/{userEmail}")
    public ResponseEntity<users> getUserByEmail(@PathVariable String userEmail) {
        return userService.getUserByEmail(userEmail)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> addUsers(
        @RequestParam("firstName") String firstName,
        @RequestParam("lastName") String lastName,
        @RequestParam("userName") String userName,
        @RequestParam("phoneNumber") String phoneNumber,
        @RequestParam("userEmail") String userEmail,
        @RequestParam("userPassword") String userPassword,
        @RequestParam("userImage") MultipartFile userImage) throws IOException{
        
        byte[] imageBytes = userImage.getBytes();

        users users =new users();
        users.setFirstName(firstName);
        users.setLastName(lastName);
        users.setuserName(userName);
        users.setPhoneNumber(phoneNumber);
        users.setUserEmail(userEmail);
        users.setUserPassword(userPassword);
        users.setUserImage(imageBytes);

        users savedUser = userService.addUsers(users);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("user", savedUser);
        return ResponseEntity.ok(response);
        }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
