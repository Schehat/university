/**
*
* Copyright:    Copyright (c) <p>
* Company:      FBI<p>
* @author JŸrgen Dunkel
* @version 1.1
* Title:        Cache<p>
* Description:  haelt schon einmal benutzte Objekt im Zwischenspeicher<p>
*/

package de.fhhannover.inform.persistence;

import java.util.*;


/**
 *
 * Copyright:    Copyright (c) <p>
 * Company:      FBI<p>
 * @author Persistenz-Gruppe
 * @version 1.0
 * Cache der Persistenzschicht
 * Der Cache ist als "Singleton" realisiert. Die in der Laufzeit
 * instanzierten Objekte werden in einer Hashtable gehalten.
 */

public class Cache {
    private static Cache singleton = null;
    private static Hashtable hashtable = new Hashtable(1000);
    private static LinkedList linkedList = new LinkedList();
    private int attribute1;
    private int maxSlots;
    private float loadFactor;

    public static final int CLEAN = 1;
    public static final int DIRTY = 2;
    public static final int NEW = 3;

/**
 *  Standardkonstruktor (protected) zur Realisierung eines Singletons
 */
    protected Cache(){
      maxSlots = 1000;
		  loadFactor = 0.75F;
    }

/**
 *  statische Methode liefert die Referenz auf den Cache zurueck (Singleton).
 *  existiert noch keine Referenz wird der Cache neu instanziiert.
 */
    public static Cache exemplar(){
      if(singleton == null)            // es existiert noch keine Cache-Objekt
	     singleton = new Cache();      // Cache-Objekt wird neu instanziiert
      return singleton;                // liefert Referenz auf Cache zurueck
    }

/**
 *  neu erzeugte (persistente) Objekte muessen ueber diese Methode in den
 *  Cache gehaengt werden
 */
    public boolean addNewObject(Persistent o){
      String anOid = o.getOid();
      Slot slot = new Slot(anOid, o, NEW);
      System.out.println(anOid + " id "+ slot);
      hashtable.put(anOid, slot);
    	 //linkedList.addFirst(slot);
      return true;            // vorlaeufig
    }

/**
 *  (persistente) Objekte, die aus der Datenbank instanziiert werden,
 *  muessen ueber diese Methode in den Cache gehaengt werden
 */
    public boolean addCleanObject(Persistent o){
      String anOid = o.getOid();
      Slot slot = new Slot(anOid, o, CLEAN);
  	  hashtable.put(anOid, slot);
    	//linkedList.addFirst(slot);
      return true;            // vorlaeufig
    }

/**
 * synchronisiert ein aus der DB gelesenes Objekt
 * falls es schon im Cache wird das Cache-Objket zurückgegeben
 * sonst wird das Objekt in den Cache eingefügt
 */
    public Persistent synchronize(Persistent o){
      String anOid = o.getOid();
      // ein Parameter wegfallen !!
      Persistent tmp= getObject(anOid);
      if(tmp != null)
        return tmp;
      addCleanObject(o);
      return o;
    }

/**
 *  ueberprueft, ob das Objekt mit der Oid anOid im Cache liegt.
 *  wann ja, dann wird das Objekt zurueck geliefert
 *  sonst wird null zurueck geliefert
 */
    public Persistent getObject(String anOid){
      if (hashtable.containsKey(anOid)){     // Objekt liegt im Cache
        Slot tempSlot = (Slot)hashtable.get(anOid);
// *****************************************************************************
// ***    dient fuer Clean-up Prozeß des Caches                              ***
// *****************************************************************************
     /*   if(linkedList.contains(tempSlot)){   // sicherhaltshalber
          linkedList.remove(tempSlot);       // Slot entfernen
        	linkedList.addFirst(tempSlot);     // Slot vorne einfuegen
      	}
        else                                // duerfte nie passieren
          linkedList.addFirst(tempSlot);    // Slot vorne einfuegen*/
// *****************************************************************************
        return tempSlot.getReference();
		  }
      else
        return null;
    }

/**
 *  ueberprueft, ob das Objekt mit der Oid anOid im Cache liegt.
 *  liefert immer das Objekt mit der Oid anOid aus dem Cache oder aus
 *  der Datenbank (Reflection) zurueck.
 */

/**
 *  das Objekt mit der Oid anOid wird auf Status DIRTY gesetzt, wenn
 *  der aktuelle Status nicht NEW ist
 */
    public void setDirtyIfNotNew(Persistent o){
      String anOid = o.getOid();
      Slot slot = (Slot)hashtable.get(anOid);
      if(slot != null){                 // das Objekt liegt im Cache
        if(slot.state != NEW)           // das Objekt hat nicht den Status NEW
	     slot.state = DIRTY;           // setze Status auf DIRTY
      }
    }

/**
 *  das Objekt mit der Oid anOid wird auf Status CLEAN gesetzt
 *  wird immer aufgerufen, wenn ein Objekt erfolgreich in die Datenbank
 *  geschrieben oder ein Objekt aus der Datenbank gelesen wurde.
 */
    public void setClean(Persistent o){
      String anOid = o.getOid();
      Slot slot = (Slot)hashtable.get(anOid);
	    if(slot != null)                  // das Objekt liegt im Cache
        slot.state = CLEAN;             // setze Status auf CLEAN
    }

/**
 *  liefert den Status des Objekt mit der Oid anOid zurueck
 *  der Status entspricht den Konstanten NEW, CLEAN, DIRTY
 */
    public int getState(String anOid){
      Slot slot = (Slot)hashtable.get(anOid);
	    if (slot == null)
	        return 0;                     // das Object liegt nicht im Cache
	    else
	        return slot.state;            // das Object liegt im Cache
    }
    public int getState(Persistent o){
        return getState(o.getOid());
    }


    public void remove(Persistent o){
      String anOid = o.getOid();
      Slot slot = (Slot)hashtable.get(anOid);
		  if (slot != null)
        hashtable.remove(anOid);
    }


// *****************************************************************************
// ***    dient fuer Clean-up Prozeß des Caches                              ***
// *****************************************************************************

/**
 *  wird automatisch angestossen. Die Objekte im Cache, die die laengste
 *  Zeit nicht benutzt wurden, werden aus diesem geloescht.
 *  ueber setMaxSlots(int) und setLoadFactor(float) kann die Groesse und der
 *  maximale Fuellstand beeinflusst werden.
 *  Der Aufruf dieser Methode ist zur Zeit noch nicht implementiert !!!!!!!!!
 */
 /*   private void cleanUpCache(){
		  Slot tempSlot;
		  int size = linkedList.size();
		  int toSize = (int)(maxSlots*loadFactor);

		  for(int i=toSize;i<size;i++){
			  tempSlot = (Slot)linkedList.get(i);
			  if(tempSlot.state==CLEAN){
				  hashtable.remove(tempSlot);
				  linkedList.remove(i);
			  }
		  }
	  }*/

/**
 *  wird automatisch angestossen. Die Objekte im Cache, die die laengste
 *  Zeit nicht benutzt wurden, werden aus diesem geloescht. Alle Elemente
 *  ab den Wert toSize werden aus dem Cache geloescht
 *  Der Aufruf dieser Methode ist zur Zeit noch nicht implementiert !!!!!!!!!
 */
  /*  private void cleanUpCache(int toSize){
     Slot tempSlot;
	int size = linkedList.size();

	for(int i=toSize;i<size;i++){
          tempSlot = (Slot)linkedList.get(i);
		if(tempSlot.state==CLEAN){
		     hashtable.remove(tempSlot);
			linkedList.remove(i);
          }
     }
    }*/

/**
 *  beeinflusst den Clean-Up Prozeß der Methode CleanUpCache()
 */
    public void setMaxSlots(int i){
     maxSlots = i;
    }

/**
 *  beeinflusst den Clean-Up Prozeß der Methode CleanUpCache()
 */
    public boolean setLoadFactor(float f){
     if(f>0.1 && f<0.9){
          loadFactor = f;
		return true;
     }
	return false;
    }



// *****************************************************************************
// ***    Innere Klasse zur Verwaltung der Objekte im Cache                  ***
// *****************************************************************************

    private class Slot{
    private int state;
	  private String oid;
	  private Persistent reference;

     Slot(String oid, Persistent o, int state){  // Konstruktor
          this.state = state; this.oid = oid; this.reference = o;
     }

      public Persistent getReference(){          // liefert die Objektreferenz die durch den Slot repraesentiert wird
        return reference;
      }
    }
// *****************************************************************************
}
