package com.annakhorolets.programm.UI;

import com.annakhorolets.programm.model.Contact;
import com.annakhorolets.programm.services.ContactService;
import jdk.nashorn.internal.runtime.arrays.ArrayIndex;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Controller
{
    public Controller(UI ui, ContactService contactService)
    {
        ui_ = ui;
        contactService_ = contactService;
        bind();
    }

    private void bind()
    {
        ui_.setOnAddClicked((ActionEvent e) ->
        {
            JOptionPane.showMessageDialog(null, "Add clicked");

        });

        ui_.setOnEditClicked((ActionEvent e) ->
        {
            JOptionPane.showMessageDialog(null, "Edit clicked");

        });

        ui_.setOnRemoveClicked((ActionEvent e) ->
        {
            int row = ui_.getSelectedRow();

            if( row!=-1 )
            {
             int col = findIndex(getContactsFields(),"ID");

             Object key = ui_.getValue(row, col);
             contactService_.deleteContact((Integer)key);

             ui_.setTableData(getContacts(), getContactsFields());
            }
        });

        ui_.setTableData(getContacts(), getContactsFields());
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
        int n = 3;
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
        for (int i = 0; i < a.length; i++)
            if (a[i].equals(target))
                return i;

        return -1;
    }

    private UI ui_;
    private ContactService contactService_;
}
