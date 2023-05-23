import javax.ejb.*;

public class HelloBean implements SessionBean {
   private SessionContext ctx;

  private static final boolean VERBOSE = true;
  private void log(String s) {
    if (VERBOSE) System.out.println(s);
  }

   public String sayHello(String name)  { return "Hallo " + name; }
   // Hook-Methoden

  public void setSessionContext (SessionContext ctx) {
    log("setSessionContext called");
    this.ctx = ctx;
}
  public void ejbCreate () throws CreateException {
    log("ejbCreate called");
   }
   public void ejbRemove() {  }
   public void ejbActivate() {  }
   public void ejbPassivate()  { }
}
