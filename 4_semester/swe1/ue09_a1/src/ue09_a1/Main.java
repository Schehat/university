package ue09_a1;

public class Main {

	public static void main(String[] args) {
		Person p = new Person();
        p.setName("Abdel Kader");
        p.setVorname("Schehat");

        PersonWindow f1 = new PersonWindow(p);
        PersonWindow f2 = new PersonWindow(p);
        PersonWindow f3 = new PersonWindow(p);

        p.setName("something");
        p.setName("else");
	}

}
