package ue09_a1;

public class Person extends Model {
	private String name;
    private String vorname;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setName(String name) {
        this.name = name;
        setChanged();
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
        setChanged();
    }
}
