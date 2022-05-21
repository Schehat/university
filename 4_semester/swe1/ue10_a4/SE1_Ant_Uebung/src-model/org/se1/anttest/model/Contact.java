package org.se1.anttest.model;

public class Contact {
    
    private String telnr = null;
    private String faxnr = null;
    private String email = null;
    private String office = null;
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFaxnr() {
        return faxnr;
    }
    public void setFaxnr(String faxnr) {
        this.faxnr = faxnr;
    }
    public String getTelnr() {
        return telnr;
    }
    public void setTelnr(String telnr) {
        this.telnr = telnr;
    }
    public String getOffice() {
        return office;
    }
    public void setOffice(String office) {
        this.office = office;
    }

}
