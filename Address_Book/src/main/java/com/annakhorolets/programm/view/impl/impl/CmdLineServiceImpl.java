package com.annakhorolets.programm.view.impl.impl;

import com.annakhorolets.programm.model.Contact;
import com.annakhorolets.programm.view.impl.CmdLineService;

import java.util.HashMap;
import java.util.Map;

public class CmdLineServiceImpl implements CmdLineService {
private Map<Integer, Contact> contactList = new HashMap();

    public void showMenu() {

    }
   public void createContact(String name, int phone)
   {
       Contact contact = new Contact(name, phone);
       int id = contact.hashCode();
       this.contactList.put(id,contact);
   }

   public void editContact(String name, String newName, int newAge)
   {
       this.contactList.get();
   }




}
