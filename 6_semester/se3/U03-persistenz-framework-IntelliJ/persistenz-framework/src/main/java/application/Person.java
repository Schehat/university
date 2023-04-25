
/**
 * Title:        Person<p>
 * Description:  <p>
 */
package application;

import java.util.*;

import de.fhhannover.inform.persistence.*;

/**
 *  <p>
 * Copyright:    Copyright (c) <p>
 * Company:      <p>
 * @author Juergen Dunkel
 * @version 1.0
 */

public class Person implements Persistent {


    private String name;
    private String vorname;
    private Date geburtstag;


    public void setName(String name) {
        this.name = name;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setName(String vorname, String name) {
        this.setVorname(vorname);
        this.setName(name);
    }

    public void setGeburtstag(Date gTag) {
        this.geburtstag = gTag;
    }

    public String getName() {
        return this.name;
    }

    public String getVorname() {
        return this.vorname;
    }

    public Date getGeburtstag() {
        return this.geburtstag;
    }

    public String toString() {
        return ("Vorname: " + this.vorname + "\n" +
                "Nachname: " + this.name + "\n" +
                "Geburtstag: " + this.geburtstag + "\n");
    }

    public boolean equals(Object anObject) {
        Person p = null;
        if (anObject != null) {
            if (anObject instanceof Person) {
                p = (Person) anObject;
                // ohne Oid zu berücksichtigen !
                return this.name.equals(p.name) && this.vorname.equals(p.vorname)
                        && this.geburtstag.equals(p.geburtstag);
            }
        }
        return false;
    }

}
