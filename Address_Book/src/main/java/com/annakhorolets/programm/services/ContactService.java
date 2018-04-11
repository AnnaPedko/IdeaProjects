package com.annakhorolets.programm.services;

public interface ContactService {
    void createContact(String name, int age);
    void editContact(String name, String newName, Integer newAge, Integer key);
    void showContacts();
    void deleteContact(Integer key);
    void showContactsByName(String name);
}
