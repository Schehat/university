/**
*
* Copyright:    Copyright (c) <p>
* Company:      FBI<p>
* @author JŸrgen Dunkel
* @version 1.1
*
 Title:        BrokerFactory<p>
 * Description:  dient zum Erzeugen eines DbBrokers für eine uebergebene Klasse<p>
 */


package de.fhhannover.inform.persistence;

import java.lang.reflect.*;

public class BrokerFactory {

  static private BrokerFactory singleton = null;

  private BrokerFactory() {  }  // Singleton

  public static BrokerFactory exemplar(){
      if(singleton == null)
	     singleton = new BrokerFactory();
      return singleton;
  }
  public RelationalDbBroker getDbBrokerFor(Class anClassType){
      Class brokerClass = null;
      RelationalDbBroker rdb = null;
      Method exemplar = null;

// *****************************************************************************
// ***    Reflectionmechanismus                                              ***
// *****************************************************************************
      String s1 = anClassType.getName() + "DbBroker";

	    try{
          brokerClass = Class.forName(s1);   // erzeugt Klassenobjekt vom Typ xyzDbBroker
          exemplar = brokerClass.getMethod("exemplar",null); // Methoden-Objekt der Methode exemplar()
          rdb = (RelationalDbBroker)exemplar.invoke(null,null);
          return rdb;
        }
        catch (ClassNotFoundException e){ e.printStackTrace();}
        catch(NoSuchMethodException e){	e.printStackTrace();}    // Methode exemplar() exitiert nicht
        catch(Exception e){ System.out.println(e); }
      return null;        // sollte nicht passieren !
  }

}