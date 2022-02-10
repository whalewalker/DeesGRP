package com.DeesGRP.repository;

import com.DeesGRP.model.Contact;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InvalidObjectException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }



    @Test
    @DisplayName("Contact can be blocked")
    void accountCanBeBlocked(){
        //Given that
        PhoneBook phoneBook = new PhoneBook();
        Contact esther = new Contact("Esther", "90975674647");
        Contact adeola = new Contact("Adeola", "646464764746");
        List<Contact> contacts = new ArrayList<>(Arrays.asList(esther, adeola));
        phoneBook.setContacts(contacts);

        //When
        phoneBook.blockContact(esther.getId());

        //Assertion
        assertEquals(contacts.size(), 1);
        assertEquals(contacts.get(0).getFirstName(), adeola.getFirstName());
        assertEquals(contacts.get(0).getLastName(), adeola.getLastName());
        assertNotNull(contacts.get(0).getId());
        assertEquals(phoneBook.getBlockContact().size(), 1);
        assertTrue(phoneBook.getBlockContact().get(0).isBlock());
    }

    @Test
    @DisplayName("Contact can be added to the phonebook")
    public void contactCanBeAdded(){
        //Given that
            // I have a phonebook and a contact
        PhoneBook phoneBook = new PhoneBook();
        Contact mongoDB = new Contact("Abdullahi", "56891234091");

        //when i add contact to the phonebook
        phoneBook.addContact(mongoDB);

        //check that contact has been added
        //Todo add more test cases for better validation
        assertEquals(1, phoneBook.getContactCount());
    }

    @Test
    @DisplayName("User can delete contact")
    public void contactCanBeDeleted(){
//        Given that I have a contactList
        PhoneBook phoneBook = new PhoneBook();
        Contact contact1 = new Contact("Esther","09095861220");
        Contact contact2 = new Contact("Dami","09095861330");
        phoneBook.addContact(contact1);
        phoneBook.addContact(contact2);
        assertEquals(2,phoneBook.getContactCount());

        // contact can be deleted
        phoneBook.deleteContact(contact2.getId());
        // check that contact has been deleted
        assertEquals(1,phoneBook.getContactCount());
    }


}