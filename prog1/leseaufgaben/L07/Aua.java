public class Aua {
    public static void main(String[] args) {
        int alter = 20;
        String phase;
        
        phase = alter < 1? "Baby" : alter < 3? "Kleinkind" : alter < 6? 
        "Vorschulkind" : alter < 13? "Schulkind" : alter < 20? "Teenager" : "Erwachsen";
        
        System.out.println(phase);
    }
}