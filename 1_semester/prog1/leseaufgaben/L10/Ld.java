import java.util.ArrayList;
public class Ld {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(1);
        if (numbers.indexOf(<value>) != numbers.lastIndexOf(<value>)) {
            System.out.println("mehrfach");
        } else {
            System.out.println("allein");
        }
    }
}