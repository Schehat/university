package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import client.PersonInterface;

public interface ShopInterface extends Remote{
	void buyProduct(String id, PersonInterface pers) throws RemoteException;
}
