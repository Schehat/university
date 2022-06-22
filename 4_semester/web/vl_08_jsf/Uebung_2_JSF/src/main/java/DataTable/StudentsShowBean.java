/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTable;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author dunkel
 */
@Named(value = "studentsShowBean")
@RequestScoped
public class StudentsShowBean {
    private int nr; 
    private String vorname;
    private String name; 
    
     public String goToDetail(Student s) {
         // kopiere das Student-Objekt in die Bean-Attribute:
         this.nr = s.getNr();
         this.vorname = s.getFirstName();
         this.name = s.getLastName();
        return "showStudent";
    }
     
    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

     
    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }


}
