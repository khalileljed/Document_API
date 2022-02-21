package com.example.DocumentAPI.Service;

import com.example.DocumentAPI.exception.ResourceNotFoundException;
import com.example.DocumentAPI.model.Document;
import com.example.DocumentAPI.repository.DocumentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public Document createDocument(Document document) {
        return documentRepository.save(document);
    }

    @Override
    public Document updateDocument(Document document) {
        Optional < Document > documentDb = this.documentRepository.findById(document.getId());

        if (documentDb.isPresent()) {
            Document documentUpdate = documentDb.get();
            documentUpdate.setId(document.getId());
            documentUpdate.setBookName(document.getBookName());
            documentUpdate.setLibraryName(document.getLibraryName());
            documentUpdate.setBookPrice(document.getBookPrice());
            documentUpdate.setUnitSold(document.getUnitSold());

            documentRepository.save(documentUpdate);
            return documentUpdate;
        } else {
            try {
                throw new ResourceNotFoundException("Record not found with id : " + document.getId());
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }
        }
        return document;
    }

    @Override
    public List<Document> getAllDocument() {
        return this.documentRepository.findAll();
    }

    @Override
    public Document getDocumentById(long documentId) {
        Optional < Document > documentDb = this.documentRepository.findById(documentId);

        if (documentDb.isPresent()) {
            return documentDb.get();
        } else {
            try {
                throw new ResourceNotFoundException("Record not found with id : " + documentId);
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    @Override
    public List<Document> findByLibraryName(String libraryName) {
        List<Document> documentDb = this.documentRepository.findByLibraryName(libraryName);

        if (!documentDb.isEmpty()) {
            return documentDb;
        } else {
            try {
                throw new ResourceNotFoundException("Record not found with libraryName : " + libraryName);
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    @Override
    public void deleteDocument(long id) {
        Optional < Document > documentDb = this.documentRepository.findById(id);

        if (documentDb.isPresent()) {
            this.documentRepository.delete(documentDb.get());
        } else {
            try {
                throw new ResourceNotFoundException("Record not found with id : " + id);
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}
