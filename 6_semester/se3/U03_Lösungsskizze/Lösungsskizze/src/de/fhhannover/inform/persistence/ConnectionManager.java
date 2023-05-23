package de.fhhannover.inform.persistence;

import java.sql.*;
import java.util.ResourceBundle;
import java.util.Vector;

/**
 *
 * Copyright:    Copyright (c) <p>
 * Company:      FBI<p>
 * @author Juergen Dunkel
 * @version 1.1
 *
 * liefert Connections zur Datenbank
 * die Connection-Parameter müssen in der Property-Datei
 * connection.properties festgelegt werden
 * fuehrt Connection-Pooling durch
 */

public class ConnectionManager {

  private static ResourceBundle b;
  private static String uid;
  private static String pwd;
  private static String driver;
  private static String dburl;

  // dient dem Connection-Pooling
  private static Vector connectionPool = new Vector(50);

  static {
      // die Initialisierung von Treiber und Connect-Parameter findet
      // nur einmal statt
      // Laden der Connection-Parameter aus der Property-Datei
      b = ResourceBundle.getBundle("connect");
      // b = ResourceBundle.getBundle("connectInstantDb");
      uid    = b.getString("uid");
      pwd    = b.getString("pwd");

      driver = b.getString("driver");
      dburl  = b.getString("dburl");

      System.out.println("Account: " + uid +  "\nTreiber:  "  +  driver + "\ndburl:  " + dburl);

      try{
        // Initialisieren der Treiber-Klasse
        Class driverClass = Class.forName(driver);
      }
      catch (Exception e){
        System.out.println("Treiber konnte nicht initialisiert werden ....");
        System.exit(0);
      }
  }

  /**
   *  hole vorhandene Connection aus Pool oder erzeuge sie neu
   */
  static public Connection getConnection() throws SQLException  {
        Connection tmp = null;
        if(connectionPool.size()==0){
              tmp = newConnection();
              connectionPool.addElement(tmp);
        }
        return (Connection) connectionPool.remove(0);
  }

  public static void release(Connection conn){
        connectionPool.add(conn);
  }

  /**
   *  erzeuge neue Connection
   */
  static private Connection newConnection() throws SQLException {
    Connection conn = null;
    conn = DriverManager.getConnection (dburl, uid, pwd);
    conn.setAutoCommit(false);
    System.out.println("new Connection  ....");
    return conn;
  }

}
