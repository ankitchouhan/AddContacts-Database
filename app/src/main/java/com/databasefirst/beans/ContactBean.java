package com.databasefirst.beans;



public class ContactBean {

    String contactName,contactNumber;
    public ContactBean()
    {

    }
    public ContactBean(String contactName,String contactNumber)
    {
        this.contactName = contactName;
        this.contactNumber = contactNumber;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }
}
