/*
 * Datei: Broker.java
 * Autor: Persistenzgruppe
 * letze Aenderung :
 * $Author: dunkel $
 * $Date: 2000/05/25 15:04:00 $
 * $Log: Broker.java,v $
 *
 */


 /**
 * Title:        Broker<p>
 * Description:  abstrakte Klasse ...<p>
 */

package de.fhhannover.inform.persistence;



/**
 *
 * Copyright:    Copyright (c) <p>
 * Company:      FBI<p>
 * @author JŸrgen Dunkel
 * @version 1.0
 * abstrakter Broker.
 * oberste Instanz in der Vererbungshirachie der entsprechenden
 * Individual-Broker
 * bietet das API um ein einzelnes Objekt aus der Datenbank zu holen
 * bzw. in der Datenbank abzuspeichern
 */


public abstract class Broker {

/**
 *  abstrakte Methode (Hook-Methode)
 *  wird in der abgeleiteten Klasse implementiert
 *  holt das Objekt aus Cache oeder erzeugt den korrekten Broker
 *  ruft Hook-Methode auf und legt Objekt in den Cache
 */
    public static Persistent getObject(String anOid, Class anClassType)throws Exception{
      Cache myCache = Cache.exemplar();
      Persistent obj = myCache.getObject(anOid);
      if (obj != null)
        return obj;       // Object liegt im Cache return Objektreferenz
      else {
        Broker brokerOfTheObject = BrokerFactory.exemplar().getDbBrokerFor(anClassType);
        obj = brokerOfTheObject.readFromPermanent(anOid);
        if (obj != null)
          myCache.addCleanObject(obj);
        return obj;
      }
    }
    abstract Persistent readFromPermanent(String anOid) throws Exception; //Hook-Methode zum holen des Objekts


/**
 *  public Methode
 *  Das Object o wird in der Datenbank abgelegt
 *   ruft die Hook- Methode writeToPermanent(o, t) auf
 *   Bemerkung: Objekte werden erst bei erfolgreichem Commit auf Clean gesetzt
 *              dies geschieht in der Methode Transaction transactionCommit()
 */
    void saveObject(Persistent o, Transaction t)throws Exception{
      this.writeToPermanent(o, t);
    }

/**
 *  abstrakte Methode (Hook-Methode)
 *  wird in der abgeleiteten Klasse implementiert, sie sorgt für die weitere
 *  persistente Abspeicherung eines Objekts
 */
    abstract void writeToPermanent(Persistent o, Transaction t)throws Exception; //Hook-Methode


  /**
   * erzeugt eine oid
   * und setzt diese für das übergebenen Objekt
   * darüber hinaus wird das Objekt als neues Objekt im Cache registriert
   */
  static public void register(Persistent o){
      o.setOid( OidGenerator.getOid() );
      //System.out.println(o.getOid() + " " + o +" "+ OidGenerator.getOid());
      Cache.exemplar().addNewObject(o);
  }

}



