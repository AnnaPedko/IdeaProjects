package com.annakhorolets.programm.view.impl.impl;

import com.annakhorolets.programm.Validator.Validator;
import com.annakhorolets.programm.Validator.ValidatorFactory;
import com.annakhorolets.programm.services.ContactService;
import com.annakhorolets.programm.view.impl.CmdLineService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CmdLineServiceImpl implements CmdLineService
{

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

   public void runMenu()
   {
        boolean exit = false;
        while( !exit )
        {
            try {
                showMenu();
                int line = Integer.parseInt(br_.readLine());
                switch(line)
                {
                    case 1:
                    {
                        createContact();
                        break;
                    }
                    case 2:
                    {
                        editContact();
                        break;
                    }
                    case 3:
                    {
                        deleteContact();
                        break;
                    }
                    case 4:
                    {
                        showContacts();
                        break;
                    }
                    case 5:
                    {
                        showMenu();
                        break;
                     }
                    case 0:
                     {
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
        String name = getName("Enter name what you want create");
        Integer age = getAge("Enter age");

        contactService_.createContact(name, age);
    }

    private void editContact() throws IOException
    {
        String name = getName("Enter name what you want change");
        String newName = getName("Enter your new name");
        Integer newAge = getAge("Enter your new age");

        showContactsByName(name);

        Integer key = getKey("Insert key what you want change");

        contactService_.editContact(name, newName, newAge, key);
    }

    private void deleteContact() throws IOException
    {
        contactService_.showContacts();

        Integer key = getKey("Insert key what you want delete");

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

    private <T> T convertFromString(String value, Class<T> c)
    {
        if( c == Integer.class)
            return (T) Integer.valueOf(value);

        return (T) value;
    }

    private <T> T getParam(String text, Validator validator, Class<T> c) throws IOException
    {
        String param;
        do
        {
            System.out.println(text);
            param = br_.readLine();
        }
        while( !validator.validate(param) );

        return convertFromString(param, c);
    }

    private Integer getAge(String text) throws IOException
    {
        return getParam(text, ValidatorFactory.getValidator("age" ), Integer.class);
    }

    private Integer getKey(String text) throws IOException
    {
        return getParam(text, ValidatorFactory.getValidator("key" ), Integer.class);
    }

    private String getName(String text) throws IOException
    {
        return getParam(text, ValidatorFactory.getValidator("name" ), String.class);
    }

    private ContactService contactService_;
    private BufferedReader br_ = new BufferedReader(new InputStreamReader(System.in));
}
