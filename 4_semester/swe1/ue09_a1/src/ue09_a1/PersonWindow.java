package ue09_a1;

public class PersonWindow implements Observer {
	String textFieldName;
    String textFieldVorname;
    Person person;

    public PersonWindow(Person person) {
        this.person = person;
        person.addObserver(this);
    }

    public void update() {
        textFieldName = person.getName();
        textFieldVorname = person.getVorname();
        System.out.println(this + ": " + textFieldVorname + " " + textFieldName);
    }
}
