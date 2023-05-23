import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface HelloHome extends EJBHome {
  public Hello create() throws CreateException, RemoteException;
}
