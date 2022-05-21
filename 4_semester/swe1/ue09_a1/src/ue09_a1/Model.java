package ue09_a1;

import java.util.ArrayList;

public class Model {
	private ArrayList<Observer> observers = new ArrayList<Observer>();
    private boolean isChanged;

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObserver() {
        for (Observer o : observers) {
            o.update();
        }
        isChanged = false;
    }

    public void setChanged() {
        if (!isChanged) {
            isChanged = true;
            notifyObserver();
        }
    }
}
