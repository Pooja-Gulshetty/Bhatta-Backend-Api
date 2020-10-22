package com.bhatta.controllers;

import com.bhatta.dto.CookDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CookController {

    @RequestMapping(
            path = "/bhatta/cooks",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<CookDto> postCook(@RequestBody final CookDto cookDto) {
        return new ResponseEntity<>(cookDto, HttpStatus.OK);
    }
}
