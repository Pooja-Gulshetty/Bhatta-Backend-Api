package com.bhatta.dto;

public class CookDto {

    private final String firstName;
    private final String lastName;

    public CookDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
