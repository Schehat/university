// extract method
interface Service {
    public void a();

    public void b();
}

class B_Servicenutzer {
    Service s;

    void meth() {
        s.a();
    }
}

class B_Serviceanbieter implements Service {
    public void a() {
    };

    public void b() {
    };
}
