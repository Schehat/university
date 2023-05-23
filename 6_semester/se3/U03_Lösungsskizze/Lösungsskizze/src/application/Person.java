
/**
 * Title:        Person<p>
 * Description:  <p>

 */
package application;

import java.util.* ;
import de.fhhannover.inform.persistence.*;

/**
 *  <p>
 * Copyright:    Copyright (c) <p>
 * Company:      <p>
 * @author       Juergen Dunkel
 * @version 1.0
 */

public class Person implements Persistent
{

  protected String oid ;
  private String name ;
  private String vorname;
  private Date geburtstag ;
  private Vector adressen = new Vector();

  public Person() {
    Broker.register(this); //  setzt oid und registriert Objekt im Cache !!
  }

  public Person(String oid){  // benötigt in finder-Methoden
    this.oid = oid ;
  }

  public String getOid() {
    return this.oid ;
  }

  public void setOid(String oid)  {
    this.oid = oid ;
  }

  public Vector getAdressen() {
    if (this.adressen.size() == 0) {        // lazy Initialization
      try {
          this.adressen = AdresseDbBroker.exemplar().searchByPerson(this);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return this.adressen;
  }

  public void addAdresse(Adresse a){
    this.getAdressen();   // sicherstellen, dass der Adress-Vektor gefüllt wird
    if (! this.getAdressen().contains(a) )
          adressen.add(a);
    a.addPerson(this);
  }

  public void removeAdresse(Adresse a){
    this.getAdressen();   // sicherstellen, dass der Adress-Vektor gefüllt wird
    if (this.getAdressen().contains(a) )
            this.adressen.remove(a);
  }

  public void setAdressen(Vector v) {
    this.adressen = v;
  }

  public void setName(String name) {
    this.name = name ;
  }

  public void setVorname(String vorname) {
    this.vorname = vorname;
  }

  public void setName(String vorname, String name) {
    this.setVorname(vorname);
    this.setName(name);
  }

  public void setGeburtstag (Date gTag) {
    this.geburtstag = gTag;
  }

  public String getName() {
    return this.name ;
  }

  public String getVorname() {
    return this.vorname ;
  }

  public Date getGeburtstag() {
    return this.geburtstag;
  }

  public String toString()  {
    return ("\nID: " + this.oid + "\n" +
            "Vorname: " + this.vorname + "\n" +
            "Nachname: " + this.name + "\n" +
            "Geburtstag: " + this.geburtstag + "\n" +
            "Adressen: " + this.adressen + "\n");
  }

  public boolean equals (Object anObject){
    Person p = null;
    if (anObject != null){
      if (anObject instanceof Person){
        p = (Person) anObject;
        // ohne Oid zu berücksichtigen !
        return this.name.equals(p.name)&& this.vorname.equals(p.vorname)
                && this.geburtstag.equals(p.geburtstag);
      }
    }
    return false;
  }

}