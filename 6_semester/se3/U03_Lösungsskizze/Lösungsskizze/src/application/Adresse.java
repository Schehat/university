package application;

import de.fhhannover.inform.persistence.*;
import java.util. * ;

public class Adresse implements Persistent {
  private String oid;
  private String strasse ;
  private int zip ;
  private String ort ;
  private Vector bewohner = new Vector();

  public Adresse()  {
      Broker.register(this);
  }
  
  public Adresse(String adresseID)  {
    this.oid = adresseID;
  }
  
  public void addPerson(Person p){
    if (bewohner.size()==0)
        bewohner =getPersonen();   // sicherstellen, dass der Personenvektor gefüllt wird
    if (! this.getPersonen().contains(p) )
        this.bewohner.add(p);
  }

  public void removePerson(Person p){
    this.getPersonen();   // sicherstellen, dass der Personenvektor gefüllt wird
    if (this.getPersonen().contains(p) )
        this.bewohner.remove(p);
    p.removeAdresse(this);
  }

  public String getOid()  {
    return this.oid ;
  }

  public void setOid(String oid)  {
    this.oid = oid ;
  }

  public void setStrasse(String strasse)  {
    this.strasse = strasse ;
  }

  public void setPLZ(int quelle)  {
    this.zip = quelle ;
  }
  public void setOrt(String quelle)  {
    this.ort = quelle ;
  }

  public void setPersonen(Vector v) {
    this.bewohner = v;
  }

  public Vector getPersonen() {
    if (this.bewohner.size() == 0) {        // lazy Initialization
      try {
        this.bewohner = PersonDbBroker.exemplar().searchByAdresse(this);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return this.bewohner;
  }

  public String getStrasse()  {
    return this.strasse ;
  }
  public int getPLZ()  {
    return this.zip ;
  }
  public String getOrt()  {
    return this.ort ;
  }

  public String toString()  {
    return ("ID                         : " + this.oid  + "\n" +
            "Strasse                    : " + this.strasse + "\n" +
            "PLZ                        : " + this.zip + "\n" +
            "Ort                        : " + this.ort + "\n");
  }

  public boolean equals (Object anObject){
    Adresse a = null;
    if (anObject != null){
      if (anObject instanceof Adresse){
        a = (Adresse) anObject;
        // oid wird nicht geprüft
        return (this.zip==a.zip)
            &&  this.strasse.equals(a.strasse)
            &&  this.ort.equals(a.ort);
      }
    }
    return false;
  }
}