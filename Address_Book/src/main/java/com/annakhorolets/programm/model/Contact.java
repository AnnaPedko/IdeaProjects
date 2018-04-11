package com.annakhorolets.programm.model;

public class Contact {

    private String name_;
    private Integer age_;

    public Contact(String name, Integer age) {
        this.name_ = name;
        this.age_ = age;
    }

    public String getName_() {
        return name_;
    }

    public Integer getAge_() {
        return age_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }

    public void setAge_(int age_) {
        this.age_ = age_;
    }


}
