import java.util.ArrayList;
public class LesAuf_816 {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<String>();
        words.add("Programmieren");   
        words.add("finde"); 
        words.add("ich"); 
        words.add("gut"); 
        
        System.out.println("Anzahl der Elemente: " + words.size());
        
        words.add(words.size() - 1, "echt");
        words.add(words.size() - 1, "total");
        
        System.out.println(words);
        
        words.set(1, words.get(1).toUpperCase());
        System.out.println(words);
        
        String temp = null;
        
        for (int i = words.size()-1; i >= 0; i--) {
            temp = words.get(i);
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == 'c') {
                    words.remove(i);
                }
            }
        }
        System.out.println(words);
    }
}