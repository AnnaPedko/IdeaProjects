package com.annakhorolets.programm.services.impl;

import com.annakhorolets.programm.model.Contact;
import com.annakhorolets.programm.services.ContactService;

public class ContactServiceImpl implements ContactService {
    public void createContact(String name, int age) {
        Contact contact = new Contact(name, age);
    }

    public void editContact(String name, String newName, String newAge) {

    }

    public void showContact(String name) {

    }

    public void showContacts() {

    }

    public void removeContact(String name) {

    }
}

