package com.example.ccsd.WebsiteImages;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebImageRepository extends MongoRepository<WebsiteImages, String> {
    
}
