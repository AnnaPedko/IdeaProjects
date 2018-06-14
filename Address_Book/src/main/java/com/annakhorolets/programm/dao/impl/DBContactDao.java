package com.annakhorolets.programm.dao.impl;

import com.annakhorolets.programm.dao.ContactDao;
import com.annakhorolets.programm.model.Contact;

import java.sql.*;
import java.util.ArrayList;

public class DBContactDao implements ContactDao
{
    public DBContactDao()
    {
        try
        {
            Class.forName("org.h2.Driver");
        }
        catch( ClassNotFoundException e )
        {
            System.out.println("Cannot connect to DB");
        }

        try( Connection connection = DriverManager.getConnection(DB_URL, USER_, PASSWORD_);
             Statement  st         = connection.createStatement() )
        {
            st.execute("CREATE TABLE IF NOT  EXISTS CLIENT(ID INT AUTO_INCREMENT PRIMARY KEY, NAME VARCHAR(255), AGE INT);");
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    }

    @Override
    public void saveContact(Contact contact)
    {
        try( Connection connection = DriverManager.getConnection(DB_URL, USER_, PASSWORD_);
             PreparedStatement st  = connection.prepareStatement("INSERT INTO CLIENT(NAME, AGE) VALUES(?, ?);") )
        {

            st.setString(1, contact.getName());
            st.setInt(2, contact.getAge());

            st.execute();
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteContact(Integer key)
    {
        try( Connection connection  = DriverManager.getConnection(DB_URL, USER_, PASSWORD_);
              PreparedStatement st  = connection.prepareStatement("DELETE FROM CLIENT WHERE ID = ?") ) {

            st.setInt(1, key);
            st.executeUpdate();
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    }

    @Override
    public void editContact(String name, String newName, Integer newAge, Integer key)
    {
        try( Connection connection = DriverManager.getConnection(DB_URL, USER_, PASSWORD_);
              PreparedStatement st  = connection.prepareStatement("UPDATE CLIENT SET NAME = ?,  AGE = ? WHERE NAME = ? AND ID = ?;"))
        {
            st.setString(1, newName);
            st.setInt(2, newAge );
            st.setString(3, name);
            st.setInt(4, key);

            st.execute();
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    }

    @Override
    public void showAll() {
        try( Connection connection  = DriverManager.getConnection(DB_URL, USER_, PASSWORD_);
              Statement  st         = connection.createStatement() )
        {
            try( ResultSet resultSet = st.executeQuery("SELECT * FROM CLIENT;") )
            {
                while( resultSet.next() )
                {
                    int     id      = resultSet.getInt("id");
                    String  name    = resultSet.getString("name");
                    int     age     = resultSet.getInt("age");
                    Contact contact = new Contact(id, name, age);

                    System.out.println(contact);
                }
            }
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    }

    @Override
    public void showContactsByName(String name)
    {
        try( Connection connection = DriverManager.getConnection(DB_URL, USER_, PASSWORD_);
              Statement  st         = connection.createStatement() )
        {
            try( ResultSet resultSet = st.executeQuery("SELECT * FROM CLIENT WHERE NAME = '" +  name + "';") )
            {
                while( resultSet.next() )
                {
                    int     id         = resultSet.getInt("id");
                    String  name_field = resultSet.getString("name");
                    int     age        = resultSet.getInt("age");
                    Contact contact    = new Contact(id, name_field, age);

                    System.out.println(contact);
                }
            }
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    }

    public ArrayList<Contact> getContacts()
    {
        ArrayList contacts = new ArrayList<Contact>();
        try( Connection connection = DriverManager.getConnection(DB_URL, USER_, PASSWORD_);
             Statement  st          = connection.createStatement() )
        {
            try( ResultSet resultSet = st.executeQuery("SELECT * FROM CLIENT") )
            {
                while( resultSet.next() )
                {
                    Integer id         = resultSet.getInt("id");
                    String  name_field = resultSet.getString("name");
                    Integer age        = resultSet.getInt("age");
                    contacts.add(new Contact(id, name_field, age));
                }
            }
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
        return contacts;
    }

    public Contact getContact(Integer idField)
    {
        Contact contact = new Contact();
        try( Connection connection  = DriverManager.getConnection(DB_URL, USER_, PASSWORD_);
              Statement  st         = connection.createStatement() )
        {
            try( ResultSet resultSet = st.executeQuery("SELECT * FROM CLIENT WHERE ID = " +  idField) )
            {
                while( resultSet.next() )
                {
                    Integer id         = resultSet.getInt("id");
                    String  name_field = resultSet.getString("name");
                    Integer age        = resultSet.getInt("age");
                            contact    = new Contact(id, name_field, age);
                }
            }
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }

        return contact;

    }

    public ArrayList<Object> getColumnsNames()
    {
        ArrayList columnNames = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(DB_URL, USER_, PASSWORD_);
             Statement  st         = connection.createStatement())
        {
            try( ResultSet resultSet = st.executeQuery("SELECT * FROM CLIENT") )
            {
                ResultSetMetaData rsmd = resultSet.getMetaData();
                for( int i = 1; i <= rsmd.getColumnCount(); i++ )
                    columnNames.add(rsmd.getColumnName(i));
            }
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
        return columnNames;
    }

    public  static final String DB_URL    = "jdbc:h2:tcp://localhost/~/Program";
    private static final String USER_     = "Test";
    private static final String PASSWORD_ = "";
}

