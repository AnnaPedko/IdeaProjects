package com.annakhorolets.programm.model;

public class Contact
{
    public Contact(Integer id, String name, Integer age)
    {
        name_ = name;
        age_  = age;
        id_   = id;
    }

    public Contact()
    {

    }

    public String getName()
    {
        return name_;
    }

    public Integer getAge()
    {
        return age_;
    }

    public void setName(String name)
    {
        name_ = name;
    }

    public void setAge(Integer age)
    {
        age_ = age;
    }

    public void setId(Integer id)
    {
        id_ = id;
    }

    public Integer getId()
    {
        return id_;
    }

    public void setParameter(String param, String value)
    {
        switch(param)
        {
            case "id":
            {
                setId(Integer.parseInt(value));
                break;
            }
            case "name":
            {
                setName(value);
                break;
            }
            case "age":
                setAge(Integer.valueOf(value));
                break;
        }
    }

    @Override
    public String toString()
    {
        return "id=" + id_ + ";name=" + name_ + ";age=" + age_;
    }

    private String  name_;
    private Integer age_;
    private Integer id_;
}
