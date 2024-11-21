package com.example.ccsd.WebsiteTexts;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface websitetextsRepository extends MongoRepository<WebsiteTexts, String> {
}
