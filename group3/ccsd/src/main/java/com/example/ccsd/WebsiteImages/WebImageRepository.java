package com.example.ccsd.WebsiteImages;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public class WebImageRepository extends MongoRepository<WebImage, String> {
    
}
