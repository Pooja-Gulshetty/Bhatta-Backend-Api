package com.bhatta.controllers;

import com.bhatta.dto.UserDto;
import com.bhatta.exceptions.InvalidRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/bhatta/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserDto> createUser(@RequestBody final UserDto userDto) {
        validateUser(userDto);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    private void validateUser(UserDto userDto) {
        if (userDto.getFirstName() == null || userDto.getFirstName().isEmpty()) {
            throw new InvalidRequest("First name should not be null or empty");
        }
    }
}
