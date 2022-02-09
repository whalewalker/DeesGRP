package com.DeesGRP.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Contact {
    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private boolean isBlock;
    private String email;


    public Contact(String firstName, String phoneNumber) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.isBlock = false;
    }

    public Contact(String firstName, String lastName, String phoneNumber, String email) {
        this(firstName, phoneNumber);
        this.lastName = lastName;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isBlock() {
        return isBlock;
    }

    public void setBlock(boolean block) {
        isBlock = block;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
