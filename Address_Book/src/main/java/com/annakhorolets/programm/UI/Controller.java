package com.annakhorolets.programm.UI;

import com.annakhorolets.programm.Validator.ValidatorFactory;
import com.annakhorolets.programm.model.Contact;
import com.annakhorolets.programm.services.ContactService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Controller
{
    public Controller(UI ui, ContactService contactService)
    {
        ui_             = ui;
        contactService_ = contactService;
        bind();
    }

    private void bind()
    {
        ui_.setTableData(getContacts(), getContactsFields());

        ui_.setOnAddClicked((ActionEvent e) ->
        {
            if (getContactFields())
            {
                contactService_.createContact(ui_.getName(),Integer.parseInt(ui_.getAge()));
                updateTable();
            }
        });

        ui_.setOnRemoveClicked((ActionEvent e) ->
        {
            int row = ui_.getSelectedRow();
            if( row != -1 )
            {
                 int col = findIndex(getContactsFields(),"ID");

                 Object key = ui_.getValue(row, col);
                 contactService_.deleteContact((Integer)key);

                 ui_.setTableData(getContacts(), getContactsFields());
            }
        });

        ui_.setOnEditClicked((ActionEvent e) ->
        {
            int     row  = ui_.getSelectedRow();
            if( row != -1 )
            {
                int     col         = findIndex(getContactsFields(),"ID");
                Object  key         = ui_.getValue(row, col);
                Integer contactKey  = (Integer)key;
                Contact contact     = contactService_.getContact(contactKey);

                String  contactId   = contact.getId().toString();
                String  contactName = contact.getName();
                String  contactAge  = contact.getAge().toString();

                ui_.setId(contactId);
                ui_.setName(contactName);
                ui_.setAge(contactAge);

                int result = ui_.showEditDialog();

                if( result == JOptionPane.OK_OPTION )
                {
                    if( !(ui_.getName().equals(contactName)) || !(ui_.getAge().equals(contactAge)) )
                    {
                        while( ! (validateAge() && validateName()))
                        {
                            int res = ui_.showEditWarningDialog();
                            if (res == JOptionPane.CANCEL_OPTION)
                                return;
                        }

                        contactService_.editContact(contactName, ui_.getName(), Integer.parseInt(ui_.getAge()), contactKey);
                    }
                }
                ui_.setTableData(getContacts(), getContactsFields());
            }
        });
    }

    public Object[][] getContacts()
    {
        return convertToDoubleArray(contactService_.getContacts());
    }

    public Object [] getContactsFields()
    {
        return convertToArray(contactService_.getColumnsNames());
    }

    public Object[][] convertToDoubleArray( ArrayList<Contact>contacts)
    {
        int m = contacts.size();
        int n = Contact.class.getDeclaredFields().length;
        int i = 0;
        Object[][] contactsArray = new Object[m][n];

        for (Contact contact:contacts)
        {
            contactsArray[i] = contact.getArrayOfParameters();
            i++;
        }

        return contactsArray;
    }

    public Object[] convertToArray(ArrayList<Object>array)
    {
        Object[] result = new Object[array.size()];
        return array.toArray(result);
    }

    public static int findIndex(Object[] a, Object target)
    {
        for( int i = 0; i < a.length; ++i )
        {
            if(a[i].equals(target))
                return i;
        }

        return -1;
    }

    public  boolean getContactFields()
    {
        int result = ui_.showDialog();

        if( result == JOptionPane.OK_OPTION )
        {
            while( !(validateAge() && validateName()) )
            {
                int res = ui_.showWarningDialog();
                if (res == JOptionPane.CANCEL_OPTION)
                    return false;
            }

            return true;
        }

        return false;
    }

    public void updateTable()
    {
        ui_.setTableData(getContacts(), getContactsFields());
    }

    public  boolean  validateName()
    {
        return ValidatorFactory.getValidator("name").validate(ui_.getName());
    }

    public  boolean  validateAge()
    {
        return ValidatorFactory.getValidator("age").validate(ui_.getAge());
    }

    private UI             ui_;
    private ContactService contactService_;
}
