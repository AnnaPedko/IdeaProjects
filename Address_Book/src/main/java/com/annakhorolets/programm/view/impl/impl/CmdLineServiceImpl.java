package com.annakhorolets.programm.view.impl.impl;

import com.annakhorolets.programm.Validator.ValidateName;
import com.annakhorolets.programm.Validator.Validator;
import com.annakhorolets.programm.services.ContactService;
import com.annakhorolets.programm.view.impl.CmdLineService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CmdLineServiceImpl implements CmdLineService {

    public CmdLineServiceImpl(ContactService contactService)
    {
        contactService_ = contactService;
    }

    public void showMenu()
    {
        System.out.println("0 - Exit");
        System.out.println("1 - create contact");
        System.out.println("2 - edit contact");
        System.out.println("3 - delete contact");
        System.out.println("4 - show contacts");
        System.out.println("5 - show menu");
    }

   public void runMenu() {
        boolean exit = false;
        while( !exit )
        {
            try {
                showMenu();
                int line = Integer.parseInt(br.readLine());
                switch(line)
                {
                    case 1: {
                        createContact();
                        break;
                    }
                    case 2: {
                        editContact();
                        break;
                    }
                    case 3: {
                        deleteContact();
                        break;
                    }
                    case 4: {
                        showContacts();
                        break;
                    }
                    case 5: {
                        showMenu();
                        break;
                    }
                    case 0: {
                        exit = true;
                        System.out.println("You pressed Exit");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println("Enter valid value");
                continue;
            }
        }
    }

    private void createContact() throws IOException
    {
        System.out.println("Enter name");
        String name = new ValidateName().getName();


        System.out.println("Enter age");
        int age = Integer.parseInt(br.readLine());

        contactService_.createContact(name, age);
    }

    private void editContact() throws IOException
    {
        System.out.println("Enter name");
        String name = br.readLine();

        System.out.println("Enter new name");
        String newName = br.readLine();

        System.out.println("Enter age");
        Integer newAge = Integer.parseInt(br.readLine());

        showContactsByName(name);

        System.out.println("Insert key what you want change");

        Integer key = Integer.parseInt(br.readLine());

        contactService_.editContact(name, newName, newAge, key);
    }

    private void deleteContact() throws IOException
    {
        showContacts();

        System.out.println("Insert key what you want delete");

        Integer key = Integer.parseInt(br.readLine());

        contactService_.deleteContact(key);
    }

    private void showContacts()
    {
        contactService_.showContacts();
    }

    private void showContactsByName(String name)
    {
        contactService_.showContactsByName(name);
    }

    private ContactService contactService_;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
}
