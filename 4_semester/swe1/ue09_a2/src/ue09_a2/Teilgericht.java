package ue09_a2;

import java.util.ArrayList;

public class Teilgericht extends Gericht {
	private ArrayList<Gericht> gerichte = new ArrayList<Gericht>();

    public Teilgericht() {
    }

    @Override
    public int getKalorien() {
        int sum = 0;
        for (int i = 0; i < gerichte.size(); ++i) {
            sum += gerichte.get(i).getKalorien();
        }
        return sum;
    }

    @Override
    public void addGericht(Gericht g) {
        gerichte.add(g);
    }

    @Override
    public void removeGericht(Gericht g) {
        gerichte.remove(g);
    }
}
