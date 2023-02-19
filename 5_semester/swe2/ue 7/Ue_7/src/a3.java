import java.util.ArrayList;
import java.util.Date;

class Student {
    private String vorname, nachname;
    private ArrayList<IBAN> iban;
}

class IBAN {
    private String iban;
    private Date validity;
    private Geldinstitut geldinstitut;
}

class Geldinstitut {
    private String name;
}
