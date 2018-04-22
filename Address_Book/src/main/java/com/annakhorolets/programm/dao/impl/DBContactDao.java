package com.annakhorolets.programm.dao.impl;

import com.annakhorolets.programm.dao.ContactDao;
import com.annakhorolets.programm.model.Contact;

import java.sql.*;

public class DBContactDao implements ContactDao
{
    public static final String DB_URL = "jdbc:h2:tcp://localhost/~/Program";

    public DBContactDao()
    {
        try
        {
            Class.forName("org.h2.Driver");
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Cannot connect to DB");
        }

        try (Connection connection = DriverManager.getConnection(DB_URL, "Test", "");

             Statement st = connection.createStatement())
        {
            st.execute("CREATE TABLE CLIENT (ID BIGINT auto_increment NOT NULL PRIMARY KEY, NAME VARCHAR(255), AGE INT);") ;
        }

         catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void saveContact(Contact contact)
    {
        try (Connection connection = DriverManager.getConnection(DB_URL, "Test", "");

             PreparedStatement st = connection.prepareStatement("INSERT INTO CLIENT VALUES(?, ?);"))
        {
            st.setString(1, contact.getName());
            st.setInt(2, contact.getAge());
            st.execute();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteContact(Integer key) {

    }

    @Override
    public void editContact(String name, String newName, Integer newAge, Integer key)
    {

    }

    @Override
    public void showAll() {

    }

    @Override
    public void showContactsByName(String name) {

    }
}

