package com.intern.demo.customer;

import java.util.UUID;

public class Customer {

    private final UUID customerId;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Gender gender;

    public Customer(UUID customerId,
                    String firstName,
                    String lastName,
                    String email,
                    Gender gender) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
    }

    public UUID getcustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }



    enum Gender{
        MALE, FEMALE
    }
}
