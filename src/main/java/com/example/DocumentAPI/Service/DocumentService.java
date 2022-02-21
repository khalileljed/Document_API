package com.example.DocumentAPI.Service;

import com.example.DocumentAPI.model.Document;

import java.util.List;

public interface DocumentService {
    Document createDocument(Document document);

    Document updateDocument(Document document);

    List< Document > getAllDocument();
    List< Document > findByLibraryName(String libraryName);
    Document getDocumentById(long documentId);

    void deleteDocument(long id);
}
