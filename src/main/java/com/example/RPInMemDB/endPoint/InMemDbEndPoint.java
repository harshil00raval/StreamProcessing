package com.example.RPInMemDB.endPoint;

import com.example.RPInMemDB.imschema.Schema;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InMemDbEndPoint {

    private final Schema schema;

    public InMemDbEndPoint(Schema schema){
        this.schema = schema;
    }


}
