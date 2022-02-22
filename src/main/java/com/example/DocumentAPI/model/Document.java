package com.example.DocumentAPI.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@org.springframework.data.mongodb.core.mapping.Document(collection = "DocumentDB")
public class Document {
    private Long id;
    private String libraryName;
    private String bookName;
    private float bookPrice;
    private int unitSold;

}
