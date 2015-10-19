


package com.mycompany.addressbookv4.model;


public class Address {

    private int contactId;
    private String fName;
    private String lName;
    private String street;
    private String city;
    private String state;
    private String zip;



    public Address() {
    }

    public Address(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

    public Address(String fName, String lName, String street, String city, String state, String zip) {
        this.fName = fName;
        this.lName = lName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
    
    
    

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
    
    public String getFirstName() {
        return fName;
    }

    public void setFirstName(String fName) {
        this.fName = fName;
    }

    public String getLastName() {
        return lName;
    }

    public void setLastName(String lName) {
        this.lName = lName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
    
    public String toString() {
        return fName + ' ' + lName +'\n' +
                street + '\n' + 
                city + ", " + state + ' ' + zip;             
    }
}
