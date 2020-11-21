package com.bhatta.services;

import com.bhatta.domain.UserDetails;
import com.bhatta.dto.UserDto;
import com.bhatta.exceptions.ConflictException;
import com.bhatta.repository.UserRepository;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import static org.mockito.ArgumentMatchers.any;

public class UserServiceImplTest {

  @Test(expectedExceptions = ConflictException.class,
      expectedExceptionsMessageRegExp = "User with phone number abc0 already exists. Unable to create new user for same phone number")
  public void testUserCreation() {
    final UserDto userDto =
        new UserDto("pooja", "pooja", "abc0", "avsnmvd", "dhkjh");
    final UserDetails userDetails = new UserDetails(userDto.getFirstName(), userDto.getLastName(), userDto.getPhoneNumber(), userDto.getEmailAddress(), userDto.getBillingAddress(), true);

    UserRepository userRepository = Mockito.mock(UserRepository.class);
    Mockito.when(userRepository.getUser(userDto.getPhoneNumber())).thenReturn(userDetails);

    UserServiceImpl userService = new UserServiceImpl(userRepository);

    userService.createUser(userDto);
  }

  @Test
  public void create() {
    final UserDto userDto =
        new UserDto("pooja", "pooja", "abc0", "avsnmvd", "dhkjh");
    UserRepository userRepository = Mockito.mock(UserRepository.class);
    Mockito.when(userRepository.getUser(userDto.getPhoneNumber())).thenReturn(null);
    UserServiceImpl userService = new UserServiceImpl(userRepository);

    userService.createUser(userDto);

    Mockito.verify(userRepository, Mockito.times(1)).storeUser(any());
  }

}