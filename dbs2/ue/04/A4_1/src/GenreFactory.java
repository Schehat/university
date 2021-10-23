import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GenreFactory {
    public static Genre findByGenreId(int genreId) throws SQLException {
        boolean ok = false;
        
        String genre;
        String SQL = "SELECT Genre FROM Genre WHERE GenreID = ?";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            stmt.setLong(1, genreId);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            
            genre = rs.getString("Genre");
            
            ConnectionManager.getConnection().commit();
        } finally {
            if (!ok) {
                ConnectionManager.getConnection().rollback();
            }
        }
        return new Genre(genreId, genre);
    }
    
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
        } finally {
            if (!ok) {
                ConnectionManager.getConnection().rollback();
            }
        }
        return genres;
    }
}
