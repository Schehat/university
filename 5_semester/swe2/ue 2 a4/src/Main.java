
public class Main {

	public static void main(String[] args) {
		PKW pkw = new Lederausstattung(new Klimaanlage(new ModellA(10000), 2000), 1000);
		System.out.println(pkw.getPreis());
		System.out.println(pkw.getBeschreibung());
	}
}
