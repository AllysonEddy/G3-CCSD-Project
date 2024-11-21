package com.example.ccsd.Gallery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface galleryRepo extends MongoRepository<gallery, String> {
}
