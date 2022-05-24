package ue09_a2;

public class Gericht {
	private String name;
    private int kalorien;

    public Gericht() {

    }

    public Gericht(String name, int kalorien) {
        this.name = name;
        this.kalorien = kalorien;
    }

    public String getName() {
        return name;
    }

    public int getKalorien() {
        return kalorien;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKalorien(int kalorien) {
        this.kalorien = kalorien;
    }

    public void addGericht(Gericht g) {

    }

    public void removeGericht(Gericht g) {

    }
}
