package de.fhhannover.inform.persistence;

import java.util.*;
import java.sql.*;


/**
 *
 * Copyright:    Copyright (c) <p>
 * Company:      FBI<p>
 * @author JŸrgen Dunkel
 * @version 1.1
 * Transaktionsklammer der Persistenzschicht
 * Die Transactions-Klasse stellt eine logisch Klammer fuer zusammengehoerige Objekte
 * bei einer Transaktion dar. Sie stellt auch Commit- und Rollbackmechanismen bereit.
 */

public class Transaction {
    private Vector transactionObjects = null;           // haelt alle Objekte, die zu einer Transaktion gehoeren
    private Cache cache;
    private Connection myConnection = null;

/**
 *  Im Standardkonstruktor werden die privaten Memberattribute instanziert.
 *  Ausserdem wird Connection-Object fuer die Transaktion geholt
 */
    public Transaction() throws SQLException{
        myConnection = ConnectionManager.getConnection();
        this.transactionObjects = new Vector();
        this.cache = Cache.exemplar();
    }

    public Connection getConnection(){
      return myConnection;
    }


/**
 *  fuegt das Object o in der Transactionsklasse ein
 */
    public void addObject(Persistent p){
      transactionObjects.addElement(p);
    }
    public void addRelation(Persistent p, Vector relatedObjects){
      transactionObjects.add(  new Relation(p, relatedObjects) );
    }

/**
 *  schreibt alle sich in der "Klammer" befindenden Objekte gegen die Datenbank
 */
    public void transactionCommit() throws Exception{
      try{
  		    saveAllObjects();
          myConnection.commit();    // Commit auf JDBC-Connection
          cleanCache();             // nun sind alle Objekte der Transaktion clean
          System.out.println("Transaction-commit");
      }
      catch(SQLException e1){                     // Fehler bei Transaktion
          try{
            myConnection.rollback();
            throw e1;                               // Exception hochreichen
          }
          catch(SQLException e2){                   // Fehler bei  rollback zur Db
            System.out.println("Fehler beim Rollback");
            throw e2;
          }
      }
      finally{
        ConnectionManager.release(this.myConnection);   // gebe connection frei
      }
   }

   private void saveAllObjects() throws Exception{
      Object o;  
      Enumeration allObjects = transactionObjects.elements();
      while (allObjects.hasMoreElements()  )
      {
          o = allObjects.nextElement();
          if (o instanceof Persistent)
              handleObject ( ( Persistent) o );
          if (o instanceof Relation)
              handleRelation( ( Relation) o );
      }
   }

   private void handleObject(Persistent p ) throws Exception  {
          if(cache.getObject(p.getOid()) == null)   // Object noch nicht im Cache
              cache.addNewObject(p);
          cache.setDirtyIfNotNew(p);        // weil dies nicht in den fachlichen setter-Methoden passiert
          Broker b = BrokerFactory.exemplar().getDbBrokerFor(p.getClass()); // erzeugte xyzDbBroker
          b.saveObject(p, this);
   }

   private void handleRelation(Relation r) throws Exception  {
          RelationalDbBroker b = BrokerFactory.exemplar().getDbBrokerFor(r.getObject().getClass()); // erzeugte xyzDbBroker
          b.saveAssociations(r.getObject(), r.getRelatedObjects(), this);
   }

   private void cleanCache() {
      Enumeration objectsInTransaction = transactionObjects.elements();
      Object o;
      while (objectsInTransaction.hasMoreElements()  )
      {
            o = objectsInTransaction.nextElement();
            if (o instanceof Persistent){
              Persistent p = (Persistent) o;
              cache.setClean(p);
            }
      }
   }

   private class Relation
   {
      private Persistent object;
      private Vector relatedObjects;

      Relation (Persistent object, Vector relatedObjects){
        this.object = object;
        this.relatedObjects = relatedObjects;
      }

      Persistent getObject(){
        return this.object;
      }

      Vector getRelatedObjects(){
        return this.relatedObjects;
      }

   }

}
