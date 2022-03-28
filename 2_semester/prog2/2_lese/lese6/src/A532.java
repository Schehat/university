
import java.io.*;
public class A532 {
    public static void main(String[] args) throws IOException {
        Writer w= new OutputStreamWriter(new FileOutputStream(new File("test.txt")), "UTF-8");
        w.write('A');
        w.write('\n');
        w.write('€');
        w.write('\n');
        w.close();
    }
}           