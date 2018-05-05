package com.annakhorolets.programm.Validator;

public class ValidatorFactory
{
    public static Validator getValidator(String param)
    {
        Validator validator = null;
        switch (param)
        {
            case "name":
            {
                validator = new ValidateName();
                break;
            }
            case "age":
            {
                validator = new ValidateAge();
                break;
            }
            case "key":
            {
                validator = new ValidateKey();
                break;
            }
        }

        return validator;
    }
}

