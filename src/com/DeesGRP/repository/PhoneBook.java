package com.DeesGRP.repository;

import com.DeesGRP.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook implements iPhoneable{
    private List<Contact> contacts = new ArrayList<>();
    private final List<Contact> shareContact = new ArrayList<>();
    private final List<Contact> blockContact = new ArrayList<>();



    /*
   Add a contact to the list of contacts
    */
    @Override
    public void addContact(Contact contact) {
        contacts.add(contact);
    }
    /*
    This method was created to check the count of contacts added to the phone book
     */
    public int getContactCount() {
        return contacts.size();
    }
    /*
    This method was created for test purpose, to check the list of contacts
    that have been added to the list and can be deleted later
     */
    public List<Contact> getAllContactInList() {
        return contacts;
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

    /*
    Iterate through contacts
    Find contact by Id
    set contact isBlocked to true
    remove contact from contacts
    add contact to blocked contacts
     */
    @Override
    public void blockContact(String id) {
        for (Contact contact : contacts){
            if (contact.getId().equals(id)){
                contact.setBlock(true);
                contacts.remove(contact);
                blockContact.add(contact);
                break;
            }
        }

    }

    @Override
    public Contact searchContact(String nameOrPhoneNumber) {
        return null;
    }


    /*
    This method was created for test purpose. It will be removed
    when add contact and get all contact is implemented
     */
    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Contact> getBlockContact() {
        return blockContact;
    }


}
