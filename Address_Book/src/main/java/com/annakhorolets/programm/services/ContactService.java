package com.annakhorolets.programm.services;

public interface ContactService {
    void createContact(String name, int age);
    void editContact(String name, String newName, String newAge);
    void showContact(String name);
    void showContacts();
    void removeContact(String name);
}
