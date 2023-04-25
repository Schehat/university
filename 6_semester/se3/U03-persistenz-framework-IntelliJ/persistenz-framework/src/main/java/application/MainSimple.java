package application;

import de.fhhannover.inform.persistence.*;

import java.sql.Date;
import java.util.Vector;

public class MainSimple {

    public static void main(String[] args) {

        try {
            // Person-Objekt erzeugen
            Person p1 = new Person();   //setzt automatisch die Oid
            p1.setName("Commander", "Scott");
            p1.setGeburtstag(new Date(68, 11, 9));
            Transaction t1 = new Transaction();
            t1.addObject(p1);
            t1.transactionCommit();
            System.out.println(p1);
            System.out.println("wurde erzeugt und in die Datenbank eingetragen.\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
