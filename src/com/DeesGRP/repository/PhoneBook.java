package com.DeesGRP.repository;

import com.DeesGRP.model.Contact;

import java.util.List;

public class PhoneBook implements iPhoneable{
    private List<Contact> contact;

    @Override
    /*

     */
    public void addContact(Contact contact) {

    }

    @Override
    public void deleteContact(String id) {

    }

    @Override
    public void updateContact(Contact contact, String id) {

    }

    @Override
    public List<Contact> getAllContact() {
        return null;
    }

    @Override
    public void shareContact(String id, Contact contact) {

    }

    @Override
    public void blockContact(String id) {

    }

    @Override
    public Contact searchContact(String nameOrPhoneNumber) {
        return null;
    }
}
