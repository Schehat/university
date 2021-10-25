import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 * @author Schehat
 * GenreFactory. Returns objects of the genre table inside the database
 */
public class GenreFactory {
    
    /**
     * search in the genre table after a tuple by the specified genreId
     * @param genreId
     * @return Genre object if genreId is inside the genre table else null  
     * @throws SQLException
     */
    public static Genre findByGenreId(Long genreId) throws SQLException {
        boolean ok = false;
        
        String genre = null;
        String SQL = "SELECT Genre FROM Genre WHERE GenreID = ?";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            stmt.setLong(1, genreId);
            ResultSet rs = stmt.executeQuery();
            
            // checking if ResultSet is empty
            if (rs.next()) {
                genre = rs.getString("Genre");
            } else {
                System.out.println("Datensatz mit genreId = " + genreId + " nicht vorhanden");
            }
           
            ConnectionManager.getConnection().commit();
            ok = true;
        } finally {
            if (!ok) {
                ConnectionManager.getConnection().rollback();
            }
            
        }
        
        if (ok) {
            return new Genre(new Long(genreId), genre);
        } else {
            return null;
        }
    }
    
    /**
     * 
     * @return ArrayList containing Genre objects. If table is empty then returning empty ArrayList
     * @throws SQLException
     */
    public static ArrayList<Genre> findByGenreAll() throws SQLException {
        boolean ok = false;
        
        ArrayList<Genre> genres = new ArrayList<Genre>(); 
        
        String SQL = "SELECT Genre FROM Genre";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                long genreId = rs.getLong("GenreId");
                String genre = rs.getString("Genre");
                genres.add(new Genre(genreId, genre));
            }            
            
            ConnectionManager.getConnection().commit();
            ok = true;
        } finally {
            if (!ok) {
                ConnectionManager.getConnection().rollback();
            }
        }
        
        if (genres.size() == 0) {
            System.out.println("Tabelle ist leer");
        }
        return genres;
    }
}
