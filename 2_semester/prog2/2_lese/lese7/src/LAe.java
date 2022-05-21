//class R {
//  public void r() { };
//}
//class S extends R {
//  public void s() { };
//}
//class T extends S {
//  public void t() { };
//}
//public class LAe {
//  public static void main(String[] args) {
//    R a= (R) new S(); 
//    T b= new T(); 
//    b.t();
//    ((S)b).s(); 
//    ((R)((S)b)).r();
//  }
//}

 class R {
  public void r() { };
}
class S extends R {
  public void s() { };
}
class T extends S {
  public void t() { };
}
public class LAe {
  public static void main(String[] args) {
    R a= new S(); 
    a.r();
    ((S)a).s();
    //a.t();
    S b= new S(); 
    b.r();
    b.s();
  }
}