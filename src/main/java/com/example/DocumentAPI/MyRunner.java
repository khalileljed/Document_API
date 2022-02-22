package com.example.DocumentAPI;

import com.example.DocumentAPI.model.Document;
import com.example.DocumentAPI.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component

public class MyRunner implements CommandLineRunner {
    @Autowired
    private DocumentRepository documentRepository;
    @Override
    public void run(String... args) throws Exception {

        documentRepository.deleteAll();
        documentRepository.save(new Document(1L,"Oxford","DeathNote",16F,200));
        documentRepository.save(new Document(2L,"Oxford","Mou9adma",136F,700));
        documentRepository.save(new Document(3L,"Oxford","3awassef",126F,780));
        documentRepository.save(new Document(4L,"Oxford","Fadhila",163F,2560));
        documentRepository.save(new Document(5L,"EL9ods","Arwe7 Moutamarida",165F,800));
        documentRepository.save(new Document(6L,"EL9ods","The Idiot",136F,7800));
        documentRepository.save(new Document(7L,"EL9ods","Kramazof",156F,240));
        documentRepository.save(new Document(8L,"EL9ods","Crime & Punishement",1667F,280));
    }
}
