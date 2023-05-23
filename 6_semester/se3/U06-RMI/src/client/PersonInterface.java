package client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PersonInterface extends Remote{
	void addToBill(double amount) throws RemoteException;
}
