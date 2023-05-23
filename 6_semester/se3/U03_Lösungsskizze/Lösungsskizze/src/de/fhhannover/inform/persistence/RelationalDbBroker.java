/**
 * Title:        RelationalDbBroker<p>
 * Description:  <p>
 */
package de.fhhannover.inform.persistence;

import java.sql.*;
import java.util.Vector;

/**
 *
 * Copyright:    Copyright (c) <p>
 * Company:      FBI<p>
 * @author JŸrgen Dunkel
 * @version 1.0
 * abstrakter Broker.
 * abgeleitete abstrakte Klasse von Broker.
 * kennt die eingesetzte Technologie (RDBMS)
 * realisiert die Standard-Zugriffe und holt sich die SQL-Befehle
 * über entsprechende Hook-Mehtoden
 */

public abstract class RelationalDbBroker extends Broker {

/**
 *  diese Methode holt das Object mit gegebener Oid aus der Datenbank
 */
    protected Persistent readFromPermanent(String anOid) throws SQLException
    {
        String selectString = getFindByPrimaryKeyString(anOid);
        Connection con = ConnectionManager.getConnection();
        // führe SQL-Befehl aus und hole das einzige Objekt aus dem zurückgelieferten Vector
        return (Persistent) getObjectsFromSelect(selectString).firstElement();
    }

/**
 *  diese Methode legt das Object mit Oid anOid persistent in der Datenbank ab
 *  sie entscheidet, ob ein insert oder update durchgeführt wird
 *  der Cachzustand darf erst auf Clean gesetzt werden, wenn dei Transaktion
 *  erfolgreich war (in der Methode transactionCommit(
 */
    protected void writeToPermanent(Persistent o, Transaction t) throws SQLException
    {
        Connection conn = t.getConnection();
        String sqlString = null;
        Cache myCache = Cache.exemplar();
        if(myCache.getState(o) == Cache.NEW){   // falls das Object o ein neues Object ist
          sqlString = this.getInsertString(o);
        }
        else if(myCache.getState(o) == Cache.DIRTY){ // falls das Object o schon bestehendes Object ist
          sqlString = this.getUpdateString(o);
        }
        this.executeDML(sqlString, conn); // führe den Befehl mit korrektem SQL-String durch
    }


    protected void saveAssociations(Persistent obj, Vector toObjects,
                                            Transaction t) throws SQLException
    {
           AssociationTable tab = getTable(obj, toObjects);
           AssociationsDbBroker.exemplar().saveAssociations(tab, obj, toObjects, t.getConnection());
    }

    /**
     * Hook-Methoden, die Standard-SqlBefehle liefern
     * sie werden in den speziellen DbBrokern implementiert
     */
    abstract protected String getInsertString (Persistent o);

    abstract protected String getUpdateString (Persistent o);

    abstract protected String getDeleteString (Persistent o);

    abstract protected String getFindByPrimaryKeyString(String anOid);

    abstract protected AssociationTable getTable(Persistent obj, Vector toObjects);

    /**
     * Hook-Methode, die aus einem Resultset eine Objekt erzeugt
     * wird in der Finder-Methoden readPermanent aufgerufen
     * sie wird auch in den Finder-Methoden der untergeordneten Klassen aufgerufen
     */
    abstract protected Persistent makeObject(ResultSet rs) throws SQLException;

    /**
     * private-Methode, die einen DML-Befhle ausführt und sich um Verwaltung der
     * Statements kümmert
     */
    private void executeDML(String sqlString, Connection conn)throws SQLException{
        Statement stmt = null;
        try{
      	  stmt = conn.createStatement();
          System.out.println(sqlString);
				  stmt.executeUpdate(sqlString);
        }
        catch (SQLException e){
          throw e;    // hochwerfen
        }
        finally{
          if (stmt != null) stmt.close();
        }
    }
    /**
     * private Methode, die ein Select ausführ und aus der Treffemenge einen
     * Object-Vector baut
     * dazu wird die Hook-Methode aufgerufen
     */
    protected Vector getObjectsFromSelect(String sqlSelect)throws SQLException{
        ResultSet rs = null;
        Statement stmt = null;
        Connection conn = null;
        Vector result = new Vector();
        Persistent p = null;
        try{
          conn = ConnectionManager.getConnection();
      	  stmt = conn.createStatement();
          System.out.println(sqlSelect);
          rs = stmt.executeQuery(sqlSelect);
          while(rs.next()){
            p = makeObject(rs); // Aufruf der Hook-Methode: mache Objekt aus Datensatz
            p = (Persistent) Cache.exemplar().synchronize(p);
            result.add(p);
          }
        }
        catch (SQLException e){
          throw e;    // hochwerfen
        }
        finally{
          if (stmt != null) stmt.close();
          if (conn != null) ConnectionManager.release(conn);
        }
        return result;
    }

}