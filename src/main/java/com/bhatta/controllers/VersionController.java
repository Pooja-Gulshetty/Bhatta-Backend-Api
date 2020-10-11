package com.bhatta.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

    private static final String VERSION = "{\n" +
            "            \"application\": \"Bhatta\",\n" +
            "            \"version\": \"1.0-SNAPSHOT\"\n" +
            "}";


    @RequestMapping(method = RequestMethod.GET, path = "bhatta/version", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getVersion() {
        return new ResponseEntity<>(VERSION, HttpStatus.OK);
    }
}
