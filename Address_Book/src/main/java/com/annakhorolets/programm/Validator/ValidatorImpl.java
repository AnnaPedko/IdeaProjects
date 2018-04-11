package com.annakhorolets.programm.Validator;

public abstract class ValidatorImpl implements Validator
{
    @Override
    public boolean isEmpty(String string)
    {
        return string.trim().length() == 0;
    }

    @Override
    public boolean isAlpha(String string) {
        return string.matches("[a-zA-Z]+");
    }
}
