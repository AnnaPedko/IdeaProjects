package com.annakhorolets.programm.Validator;

public class ValidatorFactory
{
    public static Validator getValidator(String param)
    {
        switch (param)
        {
            case "name":
                return new ValidateName();
            case "age":
                return new ValidateAge();
            case "key":
                return new ValidateKey();
        }

        return null;
    }
}

