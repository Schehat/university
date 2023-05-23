package client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Person extends UnicastRemoteObject implements PersonInterface{
    private String name;
    private double bill;

    public Person(String name) throws RemoteException{
        this.name = name;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public double getBill() { return bill; }

    public void addToBill(double amount) throws RemoteException{ this.bill += amount; }
}
