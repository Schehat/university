import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class XMain {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
//        ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream("x.dat"));
//        out.writeObject(new X(1)); 
//        out.writeObject(new X(2));
//        out.close();
//        
//        ObjectInputStream in= new ObjectInputStream(new FileInputStream("x.dat"));
//        System.out.println((X)in.readObject() + " " + (X)in.readObject());
//        in.close();
        ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream("x.dat"));
        ArrayList<X> li = new ArrayList<>();
        li.add(new X(1));
        li.add(new X(2));
        out.writeObject(li); 
        out.close();
        
        ObjectInputStream in= new ObjectInputStream(new FileInputStream("x.dat"));
        @SuppressWarnings("unchecked")
        // Ist keine Liste was in.readObject ausgibt ursprünglich => jetzt schon nach Modifizierung
        ArrayList<X> list= (ArrayList<X>)in.readObject();
        in.close();
        for (X i : list) {
            System.out.println(i.toString());
        }
    }
}
