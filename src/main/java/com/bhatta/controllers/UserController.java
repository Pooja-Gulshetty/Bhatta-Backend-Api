package com.bhatta.controllers;

import javax.transaction.Transactional;

import com.bhatta.dto.UserDto;
import com.bhatta.exceptions.InvalidRequest;
import com.bhatta.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(final UserService userService) {
    this.userService = userService;
  }

  @RequestMapping(
      method = RequestMethod.POST,
      path = "/bhatta/users",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  @Transactional
  public ResponseEntity<UserDto> createUser(@RequestBody final UserDto userDto) {
    validateUser(userDto);
    userService.createUser(userDto);
    return new ResponseEntity<>(userDto, HttpStatus.CREATED);
  }

  @RequestMapping(
      method = RequestMethod.GET,
      path = "/bhatta/users/{phoneNumber}",
      produces = MediaType.APPLICATION_JSON_VALUE)
  @Transactional
  public ResponseEntity<UserDto> getUser(@PathVariable("phoneNumber") final String phoneNumber) {
    UserDto userDto = userService.getUser(phoneNumber);
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
