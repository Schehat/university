import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        testInsert();
    }
    
    public static void testInsert() throws SQLException {
        boolean ok = false;
        try {
            Genre genre = new Genre();
            genre.setGenre("Unklar");
            genre.insert();
            ConnectionManager.getConnection().commit();
            ok = true;
        } finally {
            if (!ok)
                ConnectionManager.getConnection().rollback();
            }
        }
}
