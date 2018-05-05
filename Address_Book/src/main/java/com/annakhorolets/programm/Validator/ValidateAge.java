package com.annakhorolets.programm.Validator;

public class ValidateAge extends Validator
{
    public boolean validate(String param)
    {
        if( super.validate(param) )
        {
            if ( super.isNumber(param) )
            {
                if( validateLength(param) )
                {
                    return validateValue(param);
                }

                return validateLength(param);
            }

            return super.isNumber(param);
        }

        return super.validate(param);
    }

    private boolean validateValue(String param)
    {
        return Integer.parseInt(param) <= 120;
    }

    private boolean validateLength(String name)
    {
        return name.length() <= 3;
    }
}
