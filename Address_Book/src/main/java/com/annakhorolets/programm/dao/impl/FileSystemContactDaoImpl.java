package com.annakhorolets.programm.dao.impl;

import com.annakhorolets.programm.dao.ContactDao;
import com.annakhorolets.programm.model.Contact;

import java.io.*;
import java.util.ArrayList;

public class FileSystemContactDaoImpl implements ContactDao
{
    FileWriter filewriter, tempFileWriter;

    public FileSystemContactDaoImpl()
    {
        try
        {
            filewriter = new FileWriter(inputFile);
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
    }

    @Override
    public void saveContact(Contact contact)
    {
      PrintWriter writer = new PrintWriter( new BufferedWriter(filewriter));
      writer.println(contact);
      writer.flush();
    }

    @Override
    public void deleteContact(Integer key)
   {
       try ( BufferedReader reader = new BufferedReader(new FileReader(inputFile)) )
       {
           String line;
           tempFileWriter = new FileWriter(tempFile);

           while ( (line = reader.readLine()) != null )
           {
               PrintWriter tempWriter = new PrintWriter( new BufferedWriter( tempFileWriter));

               Contact contact = parseContact(line);
               if ( contact.getId().equals(key) )
               {
                   continue;
               }
               tempWriter.println(contact);
               tempWriter.flush();
           }
           copyDataBetweenFiles(tempFile, inputFile);

       }
       catch( IOException e )
       {
           e.printStackTrace();
       }
    }


    @Override
    public void editContact(String name, String newName, Integer newAge, Integer key)
    {

        try ( BufferedReader reader = new BufferedReader(new FileReader(inputFile)) )
        {
            String line;
            tempFileWriter = new FileWriter(tempFile);

            while ( (line = reader.readLine()) != null )
            {
                PrintWriter tempWriter = new PrintWriter( new BufferedWriter( tempFileWriter));

                Contact contact = parseContact(line);

                if (contact.getId().equals(key))
                {
                    contact.setName(newName);
                    contact.setAge(newAge);
                }

                tempWriter.println(contact);
                tempWriter.flush();
            }
            copyDataBetweenFiles(tempFile, inputFile);
        }
        catch( IOException e )
        {
            e.printStackTrace();
        }

    }

    @Override
    public void showAll()
    {
        try ( BufferedReader reader = new BufferedReader(new FileReader(inputFile)) )
        {
            String line;
            while ( (line = reader.readLine()) != null )
                System.out.println(line);
        }
        catch( IOException e)
        {
            e.printStackTrace();
        }
    }

    private Contact parseContact(String line)
    {
        Contact contact = new Contact();
        String[] splitString;

        for ( String retval : line.split(";") )
        {
            splitString = retval.split("=");
                for( int i = 0; i < splitString.length; i++ )
                {
                    contact.setParameter(splitString[0], splitString[1]);
                }
        }

        return contact;
    }

    public void showContactsByName(String name)
    {
        try ( BufferedReader reader = new BufferedReader(new FileReader(inputFile)) ) {

            String line;
            while ( (line = reader.readLine()) != null )
            {
                Contact contact = parseContact(line);
                if ( contact.getName().equals(name) )
                {
                    System.out.println(contact);
                }
            }
        }
        catch( IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Contact> getContacts() {
        return null;
    }


    @Override
    public ArrayList<Object> getColumnsNames() {
        return null;
    }

    @Override
    public Contact getContact(Integer ID) {
        return null;
    }

    public void copyDataBetweenFiles(File file1, File file2)
    {
        try ( BufferedReader reader = new BufferedReader(new FileReader(file1)) )
        {
            if ( file2.exists() )
            {
                file2.delete();
                filewriter = new FileWriter(file2);
            }

            PrintWriter writer = new PrintWriter( new BufferedWriter(filewriter));

            String line;
            while ( (line = reader.readLine()) != null )
            {
                writer.println(line);
            }
            writer.flush();
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
    }

     private File inputFile = new File("Data");
     private File tempFile  = new File("TempFile.txt");
}
