package com.bhatta.dto;

import java.util.Objects;

public class UserDto {
  private final String firstName;
  private final String lastName;
  private final String phoneNumber;
  private final String emailAddress;
  private final String billingAddress;

  public UserDto(String firstName,
                 String lastName,
                 String phoneNumber,
                 String emailAddress,
                 String billingAddress) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.emailAddress = emailAddress;
    this.billingAddress = billingAddress;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public String getBillingAddress() {
    return billingAddress;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserDto userDto = (UserDto) o;
    return phoneNumber.equals(userDto.phoneNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(phoneNumber);
  }
}
