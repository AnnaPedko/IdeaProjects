package com.annakhorolets.programm.Validator;

public abstract class Validator implements ValidatorInterface
{
    public boolean isEmpty(String string)
    {
        return string.trim().length() == 0;
    }

    public boolean isAlpha(String string)
    {
        return string.matches("[a-zA-Z]+");
    }

    public boolean isNumber(String string)
    {
        return string.matches("[0-9]+");
    }

    public boolean validate(String param)
    {
        return !isEmpty(param);
    }
}
