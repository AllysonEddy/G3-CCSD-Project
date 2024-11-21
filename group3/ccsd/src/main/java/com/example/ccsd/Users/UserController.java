package com.example.ccsd.Users;

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
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping
    public List<users> getAllUsers(){
        return userService.getAllUsers();
    }

     @GetMapping("/{id}")
    public ResponseEntity<users> getUserByEmail(@PathVariable String userEmail) {
        return userService.getUserByEmail(userEmail)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public users addUser(@RequestBody users user){
        return userService.addUsers(user);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userEmail){
        userService.deleteUser(userEmail);
        return ResponseEntity.noContent().build();
    }
}
