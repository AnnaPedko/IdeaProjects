package com.annakhorolets.programm.model;

public class Contact {
    private String name_;
    private int phoneNumber_;

    public Contact(String name_, int phoneNumber_) {
        this.name_ = name_;
        this.phoneNumber_ = phoneNumber_;
    }

    public String getName_() {
        return name_;
    }

    public int getPhoneNumber_() {
        return phoneNumber_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }

    public void setPhoneNumber_(int phoneNumber_) {
        this.phoneNumber_ = phoneNumber_;
    }

    @Override
    public String toString() {
        return
    }
}
