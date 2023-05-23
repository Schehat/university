package de.fhhannover.inform.persistence;

import java.sql.*;
import java.util.*;

/**
*
* Copyright:    Copyright (c) <p>
* Company:      FBI<p>
* @author JŸrgen Dunkel
* @version 1.1
*/

public class AssociationsDbBroker  {

  private static AssociationsDbBroker singleton;

  private AssociationsDbBroker() {  }

  public static AssociationsDbBroker exemplar()  {
        if (singleton == null )
            singleton= new AssociationsDbBroker();
        return singleton;
  }


  public void saveAssociations(AssociationTable tab, Persistent fromObject, Vector toObjects, Connection c)
                                                                      throws SQLException
  {
        String fromOid = fromObject.getOid();
        Vector oidsInRuntime = getOidsFromVector(toObjects);  // oid's aus Vector im Laufzeitsystem
        Vector oidsInDb = getOidsFromDb(tab, fromOid, c);        // oid's direkt aus DB

        // welche Beziehungen fehlen in der DB noch
        String runtimeOid;
        for (int i=0; i < oidsInRuntime.size(); i++) {
            runtimeOid = (String)oidsInRuntime.get(i);
            if (! oidsInDb.contains(runtimeOid))
                insert(tab, fromOid, runtimeOid, c);
        }

        // welche Beziehungen sind in der DB zu viel
        String dbOid;
        for (int i = 0; i < oidsInDb.size(); i++){
          dbOid = (String)oidsInDb.elementAt(i);
          if (! oidsInRuntime.contains(dbOid))
          delete(tab, fromOid, dbOid, c);
        }
  }

  private Vector getOidsFromVector(Vector toObjects) {
        Vector result = new Vector();
        for (int i = 0; i < toObjects.size(); i++)
          result.add( ( (Persistent)toObjects.elementAt(i) ).getOid() );
        return result;

  }
  // default Methode setzt voraus, dass die beiden Spalten in der Tabelle fromOid und toOid heissen
  private Vector getOidsFromDb(AssociationTable tab, String fromOid, Connection conn) throws SQLException {
        Vector result = new Vector();
        String selectString = "select " + tab.getVectorColumn()  + " from " + tab.getTableName() +
                              " where " + tab.getObjectColumn() + " = '" + fromOid + "'";

				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(selectString);
				while ( rs.next() )
          result.add( rs.getString(tab.getVectorColumn()) );

        stmt.close();
        return result;
  }


  private void insert(AssociationTable tab, String fromOid, String toOid, Connection myConn) throws SQLException {
 	String sqlString = "insert into " + tab.getTableName() + " ("
                      + tab.getObjectColumn() + ", " + tab.getVectorColumn()  + ") values("
                      + "'" + fromOid + "' , "	  + "'" + toOid + "' )";
        System.out.println(sqlString);
        Statement stmt = myConn.createStatement();
        stmt.executeUpdate(sqlString);
  }

  private void delete(AssociationTable tab, String fromOid, String toOid, Connection myConn) throws SQLException {
 				String sqlString = "delete " + tab.getTableName() + " where " + tab.getObjectColumn() + " = "
										+ "'" + fromOid + "'  and " + tab.getVectorColumn()  + " = '" + toOid + "' ";

				Statement stmt = myConn.createStatement();
        System.out.println(sqlString);
        stmt.executeUpdate(sqlString);
  }

}