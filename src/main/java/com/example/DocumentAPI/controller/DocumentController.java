package com.example.DocumentAPI.controller;
import java.util.List;

import com.example.DocumentAPI.Service.DocumentService;
import com.example.DocumentAPI.model.Document;
import com.example.DocumentAPI.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping("/documents")
    public ResponseEntity < List <Document>> getAllDocument() {
        return ResponseEntity.ok().body(documentService.getAllDocument());
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/documents/byLibraryName")
    public ResponseEntity<List<Document>> findByLibraryName(
            @RequestParam(name = "libraryName") String libraryName) {

        return new ResponseEntity<>(documentService.findByLibraryName(libraryName), HttpStatus.OK);
    }
    @GetMapping("/documents/{id}")
    public ResponseEntity < Document > getDocumentById(@PathVariable long id) {
        return ResponseEntity.ok().body(documentService.getDocumentById(id));
    }

    @PostMapping("/documents")
    public ResponseEntity < Document > createDocument(@RequestBody Document document) {
        return ResponseEntity.ok().body(this.documentService.createDocument(document));
    }

    @PutMapping("/documents/{id}")
    public ResponseEntity < Document > updateDocument(@PathVariable long id, @RequestBody Document document) {
        document.setId(id);
        return ResponseEntity.ok().body(this.documentService.updateDocument(document));
    }

    @DeleteMapping("/documents/{id}")
    public HttpStatus deleteDocument(@PathVariable long id) {
        this.documentService.deleteDocument(id);
        return HttpStatus.OK;
    }
}
