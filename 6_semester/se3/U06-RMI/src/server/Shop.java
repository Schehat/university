package server;

import client.PersonInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;

public class Shop extends UnicastRemoteObject implements ShopInterface{
    Hashtable hash = new Hashtable();

    public void buyProduct(String id, PersonInterface buyer) throws RemoteException{
        Product p = (Product)hash.get(id);
        buyer.addToBill(p.getPrice());
    }

    public void setProduct(Product p) {
        hash.put(p.getId(), p);
    }

    public Shop() throws RemoteException{
        this.setProduct(new Product("1", "Brot", 3.50));
        this.setProduct(new Product("2", "Bier", 8.75));
        this.setProduct(new Product("3", "Wein", 4.98));
        this.setProduct(new Product("4", "Kartoffeln", 4.21));
        this.setProduct(new Product("5", "Kaffee", 4.70));
    }

    public static void main(String[] args) {
        try {
			Shop shop = new Shop();
			LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
			Naming.rebind("localhost", shop);
			System.out.println("Shop gestartet!");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //catch (AlreadyBoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    }
}
