import java.util.Properties;
import javax.naming.*;
import javax.rmi.*;

public class HelloClient {
  public static void main(String[] args) throws Exception {
    Properties props = new Properties();
    //props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
    //props.put(Context.URL_PKG_PREFIXES, "com.sun.enterprise.naming");
     //props.put(Context.PROVIDER_URL,"localhost:3700");
    //Context ctx =  new InitialContext(props); //The most common problem developers run into is passing specific JNDI bootstrapping properties to InitialContext(args).  Some other vendors require this step but GlassFish does not.   Instead, use the no-arg InitialContext() constructor.  
    Context ctx =  new InitialContext(); 

    Object obj = ctx.lookup("helloBeanJNDI");
    HelloHome home = (HelloHome)PortableRemoteObject.narrow(obj, HelloHome.class);

    Hello hello = home.create();
    String answer = hello.sayHello("Freund");
    System.out.println (answer);
  }
}
