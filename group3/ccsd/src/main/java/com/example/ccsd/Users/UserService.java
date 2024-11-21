package com.example.ccsd.Users;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<users> getAllUsers(){
        return userRepository.findAll();
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

}
