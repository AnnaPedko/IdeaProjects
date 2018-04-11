package com.annakhorolets.programm.services.impl;

import com.annakhorolets.programm.model.Contact;
import com.annakhorolets.programm.services.ContactService;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ContactServiceImpl implements ContactService {

    public void createContact(String name, int phone)
    {
        Contact contact = new Contact(name, phone);
        int id = id_.getAndIncrement();
        contactList_.put(id, contact);
    }

    public void editContact(String name, String newName, Integer newAge, Integer key)
    {
        Contact contact = contactList_.get(key);
        contact.setName_(newName);
        contact.setAge_(newAge);
    }

    public void showContacts()
    {
        printContacts(contactList_);
    }

    public void showContactsByName(String name)
    {
        printContacts(contactList_, name);
    }

    private void printContacts(Map <Integer, Contact> mapOfValues, String name)
    {
        for( Integer key : mapOfValues.keySet() )
        {
             if( mapOfValues.get(key).getName_().equals(name) )
                 System.out.println("Key = "+ key +" ; Name = " + contactList_.get(key).getName_() + " ; Age = " + contactList_.get(key).getAge_());
        }

    }

    private void printContacts(Map<Integer, Contact> mapOfValues)
    {
        for( Integer key : mapOfValues.keySet() )
        {
            System.out.println("Key = "+ key +" ; Name = " + contactList_.get(key).getName_() + " ; Age = " + contactList_.get(key).getAge_());

        }
    }

    public void deleteContact(Integer key)
    {
        contactList_.remove(key);
    }


    private Map<Integer, Contact> contactList_ = new HashMap();
    private AtomicInteger id_ = new AtomicInteger();
}

