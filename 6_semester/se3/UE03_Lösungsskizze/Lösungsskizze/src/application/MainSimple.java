package application;

import de.fhhannover.inform.persistence.*;

import java.sql.Date;

public class MainSimple {

  public static void main(String[] args) {
    try {

      // Person-Objekt erzeugen
      Person p1 = new Person();   //setzt automatisch die Oid
      p1.setName("Commander", "Scott");
      p1.setGeburtstag(new Date(68,11,9));
      Transaction t1 = new Transaction();
      t1.addObject(p1);
      t1.transactionCommit();
      System.out.println(p1);
      System.out.println("wurde erzeugt und in die Datenbank eingetragen.\n");
      // Adresse-Objekt erzeugen
      Adresse a1 = new Adresse(); // setzt Oid
      a1.setPLZ(10111);
      a1.setOrt("Berlin");
      a1.setStrasse("Kudamm 23");
      // Adresse zu Person hinzufügen
      p1.addAdresse(a1);
      a1.addPerson(p1);
      System.out.println(a1);
      Transaction t2 = new Transaction();
      t2.addObject(a1);
      t2.addObject(p1);
      t2.addRelation(p1, p1.getAdressen());
      t2.transactionCommit(); // schreibe Objekte gegen DB und mache commit

    }
    catch (Exception e) {e.printStackTrace();}
  }

}