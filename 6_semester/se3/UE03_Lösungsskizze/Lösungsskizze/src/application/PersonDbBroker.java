/**
 * Title:        <p>
 * Description:  <p>
 * Copyright:    Copyright (c) <p>
 * Company:      <p>
 * @author
 * @version 1.0
 */

package application;

import de.fhhannover.inform.persistence.*;
import java.util.*;
import java.sql.*;

public class PersonDbBroker extends RelationalDbBroker {
  private static PersonDbBroker personDbBroker;

/**
 *  privater Standardkonstruktor zur Realisierung eines Singletons
 */
  private PersonDbBroker() {  }

  /**
 * liefert immer dieselbe statische Instanz des Brokers (Singleton)
 */
  public static PersonDbBroker exemplar() {
        if (personDbBroker == null )
            personDbBroker= new PersonDbBroker();
        return personDbBroker;
  }

  protected String getFindByPrimaryKeyString(String anOid) {
        return  "select * from Person where pers_id = '" + anOid + "'";
  }

  protected String getInsertString (Persistent o){
        Person p = (Person) o;
				return "insert into Person (pers_id, name, vorname, geburtstag) values("
								+ "'" + p.getOid()  + "' , '" + p.getName() + "', '" + p.getVorname()
                + "', {d '" + p.getGeburtstag()  + "'} )";
  }

  protected String getUpdateString (Persistent o){
        Person p = (Person) o;
        return "update Person "
				        + " set vorname = '" + p.getVorname() + "',  name = '" + p.getName() + "'"
				        + " where pers_id = '" + p.getOid() +"'";
  }

  protected String getDeleteString (Persistent o){
    Person p = (Person) o;
    /**
     vorläufig nicht implementiert
     */
    return null;
  }

  protected AssociationTable getTable(Persistent obj, Vector toObjects){
        Person p = (Person)obj;
        if (toObjects == p.getAdressen() )  // es geht um den Vector getAdressen
           return new AssociationTable("wohnt_in", "pers_id", "adr_id");
        return null;
  }

  protected Persistent makeObject(ResultSet rs) throws SQLException {
        // Konstrukor, der keine oid erzeugt, benutzen !
        Person person = new Person( rs.getString("pers_id") );
        person.setVorname( rs.getString("vorname") );
        person.setName( rs.getString("name") );
        person.setGeburtstag(rs.getDate("geburtstag"));
        person.setAdressen(person.getAdressen());
        return person;
  }

  public Vector searchByName(String name) throws SQLException {
        String selectString = "select * from Person "
				                              + " where name like  '" + name + "%'";
        return getObjectsFromSelect(selectString);
  }

    public Vector searchByAdresse(Adresse a) throws SQLException {
        String selectString =  "SELECT  * "+
                " FROM Person p , wohnt_in w where "+
                " w.adr_id = '"+ a.getOid() + "'";
        return this.getObjectsFromSelect(selectString);
    }

}