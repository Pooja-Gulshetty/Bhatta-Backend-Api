package com.bhatta.services;

import com.bhatta.domain.UserDetails;
import com.bhatta.dto.UserDto;
import com.bhatta.exceptions.ConflictException;
import com.bhatta.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

  private final UserRepository userRepository;

  @Autowired
  public UserServiceImpl(final UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void createUser(final UserDto userDto) {
    LOGGER.info("Checking whether user already exists or not for phone number:[{}]", userDto.getPhoneNumber());
    UserDetails existingUserDetails = userRepository.getUser(userDto.getPhoneNumber());

    if (existingUserDetails != null) {
      LOGGER.info("User exists, unable to create");
      throw new ConflictException("User with phone number " + userDto.getPhoneNumber() + " already exists. Unable to create new user for same phone number");
    }

    LOGGER.info("User does not exists so creating the user");
    UserDetails userDetails = new UserDetails(userDto.getFirstName(), userDto.getLastName(), userDto.getPhoneNumber(), userDto.getEmailAddress(), userDto.getBillingAddress(), false);
    userRepository.storeUser(userDetails);
    LOGGER.info("User successfully created.");
  }

  @Override
  public UserDto getUser(final String phoneNumber) {
    UserDetails user = userRepository.getUser(phoneNumber);

    if (user == null) {

    }

    return new UserDto(user.getFirstName(), user.getLastName(), user.getPhoneNumber(), user.getEmailAddress(), user.getBillingAddress());
  }
}
