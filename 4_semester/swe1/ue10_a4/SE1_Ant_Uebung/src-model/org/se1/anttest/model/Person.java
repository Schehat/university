package org.se1.anttest.model;

import java.util.Calendar;

public abstract class Person {

    private String firstname;
    private String lastname;
    private Calendar birthdate;
    
    public Calendar getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(Calendar birthdate) {
        this.birthdate = birthdate;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
}
