package com.DeesGRP.model;

import java.util.List;

public class Contact {
    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private boolean isBlock;
    private String email;
    private List<Contact> shareContact;
    private List<Contact> blockContact;
}
