package com.DeesGRP.repository;

import com.DeesGRP.model.Contact;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        List<Contact> expected = new ArrayList<>(Arrays.asList(mongoDB));
        List<Contact> actual = phoneBook.getAllContactInList();
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    @DisplayName("Contact can be shared to other contacts in the phonebook")
    public void contactCanBeSharedTest(){
        //Given that
        // I have a phonebook
        PhoneBook phoneBook = new PhoneBook();
        Contact mongoDB = new Contact("Abdullahi", "56891234091");
        Contact fola = new Contact("Afolabi", "55780123080");

        //The contact I want to share and the one I'm sharing to, exist.
        phoneBook.addContact(fola);
        phoneBook.addContact(mongoDB);

        //When
        // I can share a contact name
        phoneBook.shareContact(fola.getId(), mongoDB);

        //Assert that the contact has been added to shared contact list
        List<Contact>expected = new ArrayList<>(Arrays.asList(mongoDB));
        assertArrayEquals(expected.toArray(),phoneBook.getShareContact().toArray());

    }
}