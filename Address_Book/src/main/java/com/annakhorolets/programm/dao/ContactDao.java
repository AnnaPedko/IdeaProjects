package com.annakhorolets.programm.dao;

import com.annakhorolets.programm.model.Contact;

import java.io.IOException;

public interface ContactDao
{
    void saveContact(Contact contact);
    void deleteContact(Integer key);
    void editContact(String name, String newName, Integer newAge, Integer key);
    void showAll();
    void showContactsByName(String name);
}
