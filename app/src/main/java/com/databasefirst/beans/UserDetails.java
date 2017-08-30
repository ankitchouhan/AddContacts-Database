package com.databasefirst.beans;



public class UserDetails {

    String name;
    String password;

    public UserDetails()
    {

    }
    public UserDetails(String name,String password)
    {
        this.name = name;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
