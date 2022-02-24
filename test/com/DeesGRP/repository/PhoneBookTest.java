package com.DeesGRP.repository;

import com.DeesGRP.model.Contact;
import com.DeesGRP.model.NoFavoriteContactException;
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

    @Test

    void testContactListCanBeGotten(){
        //given that we have a phonebook and contacts
        PhoneBook phoneBook = new PhoneBook();
        Contact lota = new Contact("lota","09056819817");
        Contact dee = new Contact("dee","09056819817");
        //when we have contacts in it
        phoneBook.addContact(lota);
        phoneBook.addContact(dee);
        //assert
        assertEquals(2, phoneBook.getAllContact().size());
        List<Contact> expected = new ArrayList<>(Arrays.asList(lota, dee));  //{lota, dee}.toArray() [lota,dee]
        assertArrayEquals(expected.toArray(), phoneBook.getAllContact().toArray());
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

    @DisplayName("User can filter contact by (favorite contact, speed dail)")
    @Test
    public void testThatUserCanFilterContactByFavoriteContact() throws NoFavoriteContactException {
        //given that i have a list of contacts
        PhoneBook phonebook = new PhoneBook();
        phonebook.addContact(new Contact("Adeola","09098787876"));
        phonebook.addContact(new Contact("Lota","09092347876"));
        phonebook.addContact(new Contact("Esther","09098787776"));
        phonebook.addContact(new Contact("Dami","09098700006"));
        phonebook.addContact(new Contact("dami gey","09001787876"));
        phonebook.addContact(new Contact("Adeola1","090987879006"));

        //when i add a contact(s) to favorite
        Contact dee = new Contact("Adeola","09098787876");
        Contact esther = new Contact("Esther","09098787776");
        phonebook.addFavorite(dee, esther);
        //assert that contacts are added to favorite and i can get a list of favorite contacts

        List<Contact> favorites = phonebook.getFavoriteContacts();
        List<Contact> expected = new ArrayList<Contact>(Arrays.asList(dee, esther));
        assertArrayEquals(expected.toArray(), favorites.toArray());
    }

    @Test
    public void testThatWheNoFavoriteExitsThrowsException() {
        PhoneBook phonebook = new PhoneBook();
        phonebook.addContact(new Contact("Adeola","09098787876"));
        phonebook.addContact(new Contact("Lota","09092347876"));
        phonebook.addContact(new Contact("Esther","09098787776"));
        phonebook.addContact(new Contact("Dami","09098700006"));
        phonebook.addContact(new Contact("dami gey","09001787876"));
        phonebook.addContact(new Contact("Adeola1","090987879006"));

        assertThrows(NoFavoriteContactException.class, ()->phonebook.getFavoriteContacts());
    }

}