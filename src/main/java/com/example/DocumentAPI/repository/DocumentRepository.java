package com.example.DocumentAPI.repository;

import com.example.DocumentAPI.model.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface DocumentRepository extends MongoRepository <Document, Long > {
    public List<Document> findByLibraryName(String libraryName);

}
