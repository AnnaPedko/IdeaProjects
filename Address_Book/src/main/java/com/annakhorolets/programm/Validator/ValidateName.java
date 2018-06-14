package com.annakhorolets.programm.Validator;

public class ValidateName extends Validator
{
    private boolean validateLength(String name)
    {
        return name.length() <= 15;
    }

    public boolean validate(String param)
    {
        if( super.validate(param) )
        {
            if ( validateLength(param) )
                return super.isAlpha(param);

            return validateLength(param);
        }

        return super.validate(param);
    }
}
