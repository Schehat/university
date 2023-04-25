/**
 * Title:        <p>
 * Description:  <p>
 * Copyright:    Copyright (c) <p>
 * Company:      <p>
 *
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
    private PersonDbBroker() {
    }

    /**
     * liefert immer dieselbe statische Instanz des Brokers (Singleton)
     */
    public static PersonDbBroker exemplar() {
        if (personDbBroker == null)
            personDbBroker = new PersonDbBroker();
        return personDbBroker;
    }

    protected String getFindByPrimaryKeyString(String anOid) {
        return "select * from Person where pers_id = '" + anOid + "'";
    }

    protected String getInsertString(Persistent o) {
        Person p = (Person) o;
        return "insert into Person (pers_id, name, vorname, geburtstag) values("
                + "'" + p.getOid() + "' , '" + p.getName() + "', '" + p.getVorname()
                + "', {d '" + p.getGeburtstag() + "'} )";
    }

    protected String getUpdateString(Persistent o) {
        // PASSEND ZU ERGÄNZEN
    }

    protected Persistent makeObject(ResultSet rs) throws SQLException {
        // PASSEND ZU ERGÄNZEN
    }

    public Vector searchByName(String name) throws SQLException {
        // PASSEND ZU ERGÄNZEN
    }


    protected AssociationTable getTable(Persistent obj, Vector toObjects) {
        Person p = (Person) obj;
        if (toObjects == p.getAdressen())  // es geht um den Vector getAdressen
            return new AssociationTable("wohnt_in", "pers_id", "adr_id");
        return null;
    }

}
