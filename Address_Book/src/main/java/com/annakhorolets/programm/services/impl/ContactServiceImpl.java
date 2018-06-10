package com.annakhorolets.programm.services.impl;

import com.annakhorolets.programm.dao.ContactDao;
import com.annakhorolets.programm.model.Contact;
import com.annakhorolets.programm.services.ContactService;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ContactServiceImpl implements ContactService {

    public ContactServiceImpl(ContactDao contactDao)
    {
        contactDao_ = contactDao;
    }

    public void createContact(String name, int phone)
    {
        Integer id = id_.getAndIncrement();
        contactDao_.saveContact(new Contact(id, name, phone));
    }

    @Override
    public void showContacts()
    {
        contactDao_.showAll();
    }

    public void editContact(String name, String newName, Integer newAge, Integer key)
    {
        contactDao_.editContact(name, newName, newAge, key);
    }

    public Contact getContact(Integer key)
    {
        return contactDao_.getContact(key);
    }

    @Override
    public void deleteContact(Integer key)
    {

        contactDao_.deleteContact(key);
    }

    public void showContactsByName(String name)
    {
        contactDao_.showContactsByName(name);
    }

    public ArrayList<Contact> getContacts()
    {
        return contactDao_.getContacts();
    }

    public ArrayList<Object> getColumnsNames()
    {
        return contactDao_.getColumnsNames();
    }
    private final ContactDao contactDao_;
    private AtomicInteger id_ = new AtomicInteger();
}

