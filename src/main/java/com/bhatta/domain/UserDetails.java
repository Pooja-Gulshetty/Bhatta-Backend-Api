package com.bhatta.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users_details")
public class UserDetails {
  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Id
  @Column(name = "phone_number", unique = true)
  private String phoneNumber;

  @Column(name = "email_address")
  private String emailAddress;

  @Column(name = "billing_address")
  private String billingAddress;

  @Column(name = "enabled")
  private boolean enabled;

  protected UserDetails() {
  }

  public UserDetails(final String firstName,
                     final String lastName,
                     final String phoneNumber,
                     final String emailAddress,
                     final String billingAddress,
                     final boolean enabled) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.emailAddress = emailAddress;
    this.billingAddress = billingAddress;
    this.enabled = enabled;
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

  public boolean isEnabled() {
    return enabled;
  }
}
