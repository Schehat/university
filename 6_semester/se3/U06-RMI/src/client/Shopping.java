package client;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import server.ShopInterface;

public class Shopping {
    public static void main(String[] args) {
        Person p;
		try {
			p = new Person("Daisy Duck");
			ShopInterface s = (ShopInterface) Naming.lookup("localhost");
			System.out.println("Shop gefunden!");
			s.buyProduct("1", p);
			s.buyProduct("2", p);
			s.buyProduct("2", p);
			s.buyProduct("5", p);
			System.out.println("Summe = " + p.getBill());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
