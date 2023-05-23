package application;

import java.util.*;
import java.sql.*;
import de.fhhannover.inform.persistence.*;

/**
 *
 * Copyright:    Copyright (c) <p>
 * Company:      FBI<p>
 * @author Christian Br&uuml;ckner
 * @version 1.0
 * Der Individual-Broker f&uuml;r Datenbankzugriffe
 * auf die Tabellen von Adresse
 *
 */
public class AdresseDbBroker extends RelationalDbBroker {

  private static AdresseDbBroker mAdresseDbBroker = null;

  /**
 *  privater Standardkonstruktor zur Realisierung eines Singletons
 */
  private AdresseDbBroker() { }

/**
 * liefert immer dieselbe statische Instanz des Brokers (Singleton)
 */

  public static AdresseDbBroker exemplar()  {
    if (mAdresseDbBroker == null )
            mAdresseDbBroker= new AdresseDbBroker();
    return mAdresseDbBroker;
  }

  protected String getFindByPrimaryKeyString(String anOID) {
    return "SELECT distinct * FROM adresse where adr_id = '"+anOID + "'";
  }

  protected String getInsertString(Persistent o) {
    Adresse mAdresse = (Adresse) o;
    return "INSERT INTO adresse(adr_id,zip, ort,strasse) VALUES(" +
            "'"   + mAdresse.getOid()+
            "',"  + mAdresse.getPLZ() +
            ",'"  + mAdresse.getOrt()+
            "','" + mAdresse.getStrasse()+
            "')";
  }

  protected String getUpdateString(Persistent o) {
    Adresse mAdresse = (Adresse) o;
    return "UPDATE Adresse set " +
            "ort='"   + mAdresse.getOrt() +
            "',strasse='" + mAdresse.getStrasse() +
            "',zip=" + mAdresse.getPLZ() +
            " where adr_id='" + mAdresse.getOid() + "'";
  }

/**
 *  vorläufig nicht implementiert
 */
  protected String getDeleteString(Persistent o) {
    /* vorläufig nicht implementiert */
    return null;
  }

  protected Persistent makeObject(ResultSet rs) throws SQLException {
    // Konstrukor, der keine oid erzeugt, benutzen !
    Adresse a = new Adresse( rs.getString("adr_id") );
    a.setPLZ(rs.getInt("zip") );
    a.setOrt(rs.getString("ort"));
    a.setStrasse(rs.getString("strasse"));
    a.setPersonen(a.getPersonen());
    return a;
  }

  protected AssociationTable getTable(Persistent obj, Vector toObjects) {
    Adresse a = (Adresse)obj;
    if (toObjects == a.getPersonen())  // es geht um den Vector getPersonen
       return new AssociationTable("wohnt_in", "adr_id", "pers_id");
    return null;
  }


  public Vector searchByOrt(String ort) throws SQLException {
    String selectString = "select * from Adresse "
  	                              + " where ort like  '" + ort + "%'";
    return this.getObjectsFromSelect(selectString);
  }

  public Vector searchByPerson(Person p) throws SQLException {
    // select adr_id from person p INNER JOIN wohnt_in w ON p.pers_id=w.pers_id where p.pers_id=1
    String selectString =  "SELECT  * "+
                        " FROM adresse a , wohnt_in w where "+
                          " w.pers_id = '"+ p.getOid() + "'";
    return this.getObjectsFromSelect(selectString);
  }

}