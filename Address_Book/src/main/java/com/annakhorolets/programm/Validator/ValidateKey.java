package com.annakhorolets.programm.Validator;

public class ValidateKey extends Validator
{
    public boolean validate(String param)
    {
        if( super.validate(param) )
        {
            return super.isNumber(param);
        }

        return super.validate(param);
    }
}
