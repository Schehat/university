
public class L626 {

    public static void main(String[] args) {
        Fahrzeug myVar1= new Fahrzeug();
        Fahrzeug myVar2= new Auto();
        Fahrzeug myVar3= new SUV();
        SUV myVar4= new SUV();
        
        myVar1.bewegen();
        myVar3.bewegen();
        myVar4.bewegen();
        ((Auto)myVar3).bewegen();
        ((Auto)myVar2).anzahlRaeder();
        ((SUV)myVar3).fahreImGelaende();
        ((Auto)myVar4).anzahlRaeder();
        ((Auto)myVar1).anzahlRaeder();
        //((Auto)myVar3).fahreImGelaende();
    }

}
