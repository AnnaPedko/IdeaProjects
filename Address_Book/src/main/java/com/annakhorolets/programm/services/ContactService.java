package com.annakhorolets.programm.services;

import com.annakhorolets.programm.model.Contact;

import java.util.ArrayList;

public interface ContactService {
    void createContact(String name, int age);
    void editContact(String name, String newName, Integer newAge, Integer key);
    void showContacts();
    void deleteContact(Integer key);
    void showContactsByName(String name);
    ArrayList<Contact> getContacts();
    ArrayList<Object> getColumnsNames();
}
