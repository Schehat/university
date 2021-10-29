import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 * @author Schehat
 * MovieGenreFactory. Returns objects of the genre table inside the database
 */
public class MovieGenreFactory {
    
    /**
     * search in the MovieGenre table after a tuple by the specified genreId & movieId
     * @param genreId
     * @param movieId
     * @return MovieGenre object if genreId & movieId is inside the MovieGenre table else null  
     * @throws SQLException
     */
    public static MovieGenre findByGenreId(Long genreId, Long movieId) throws SQLException {
        String SQL = "SELECT genreId, movieId FROM MovieGenre WHERE GenreID = ? AND MovieId = ?";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            stmt.setLong(1, genreId);
            stmt.setLong(2, genreId);
            ResultSet rs = stmt.executeQuery();
            
            // checking if ResultSet is empty
            if (!rs.next()) {
                throw new SQLException("Datensatz mit genreId = " + genreId + " nicht vorhanden");
            } else if (!rs.next()) {
                throw new SQLException("Datensatz mit genreId = " + movieId + " nicht vorhanden");
            }
        }
        return new MovieGenre(genreId, movieId);
    }
    
    /**
     * 
     * @return ArrayList containing Genre objects. If table is empty then returning empty ArrayList
     * @throws SQLException
     */
    public static ArrayList<MovieGenre> findByGenreAll() throws SQLException {
        ArrayList<MovieGenre> movieGenres = new ArrayList<MovieGenre>(); 
        
        String SQL = "SELECT GenreId, MovieId FROM MovieGenre";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Long genreId = rs.getLong("GenreId");
                Long genre = rs.getLong("MovieId");
                movieGenres.add(new MovieGenre(genreId, genre));
            }            
        } 
        if (movieGenres.size() == 0) {
            System.out.println("Tabelle ist leer");
        }
        return movieGenres;
    }
}
