package com.bhatta.repository;

import com.bhatta.domain.UserDetails;

public interface UserRepository {
  void storeUser(UserDetails use);

  UserDetails getUser(String phoneNumber);
}
