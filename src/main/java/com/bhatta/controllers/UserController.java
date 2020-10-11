package com.bhatta.controllers;

import com.bhatta.dto.UserDto;
import com.bhatta.exceptions.InvalidRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

  @RequestMapping(
          method = RequestMethod.PUT,
          path = "/bhatta/users/{phoneNumber}",
          consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<UserDto> updateUser(@RequestBody final UserDto userDto,
                                            @PathVariable("phoneNumber") final String phoneNumber) {
    return new ResponseEntity<>(userDto, HttpStatus.OK);
  }

  private void validateUser(UserDto userDto) {
    if (userDto.getFirstName() == null || userDto.getFirstName().isEmpty()) {
      throw new InvalidRequest("First name should not be null or empty");
    }

    if (userDto.getLastName() == null || userDto.getLastName().isEmpty()) {
      throw new InvalidRequest("Last name should not be null or empty");
    }

    if (userDto.getBillingAddress() == null || userDto.getBillingAddress().isEmpty()) {
      throw new InvalidRequest("Billing address should not be null or empty");
    }

    if (userDto.getEmailAddress() == null || userDto.getEmailAddress().isEmpty()) {
      throw new InvalidRequest("Email address should not be null or empty");
    }

    if (userDto.getPhoneNumber() == null || userDto.getPhoneNumber().isEmpty()) {
      throw new InvalidRequest("Phone number should not be null or empty");
    }
  }
}
