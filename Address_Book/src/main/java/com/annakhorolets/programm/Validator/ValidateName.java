package com.annakhorolets.programm.Validator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ValidateName extends ValidatorImpl
{

    public String getName () throws IOException
    {
       String name = null;

        do
        {
            System.out.println("Name should contain only letters");
            name = br.readLine();
        }
        while( !super.isAlpha(name) );

        return name;
    }

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

}
