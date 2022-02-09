package com.DeesGRP.repository;

import com.DeesGRP.model.Contact;

import java.util.List;

public interface iPhoneable {
    void addContact (Contact contact);
    void deleteContact(String id);
    void updateContact(Contact contact, String id);
    List<Contact> getAllContact();
    void shareContact(String id, Contact contact);
    void blockContact(String id);
    Contact searchContact(String nameOrPhoneNumber);
}