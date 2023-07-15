package com.akshada.model;
//package com.spring.mongo.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Document(collection="FlightIdSeq")
public class DbSequence {

    private String id;
    private int seq;


}
