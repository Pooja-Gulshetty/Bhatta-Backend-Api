package com.bhatta.services;

import com.bhatta.dto.UserDto;

public interface UserService {
  void createUser(UserDto userDto);

  UserDto getUser(String phoneNumber);
}
