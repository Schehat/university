import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author Schehat
 * Genre record
 */
public class MovieGenre {
    private Long genreId;
    private Long movieId;
    
    /**
     * constructor with parameters & Long object
     * @param genreId
     * @param genre
     */
    MovieGenre (Long genreId, Long movieId) {
        setGenreId(genreId);
        setMovieId(movieId);
    }
    
    /**
     * constructor with parameters & primitive data type long
     * @param genreId
     * @param genre
     */
    MovieGenre (long genreId, long movieId) {
        setGenreId(new Long(genreId));
        setMovieId(new Long(movieId));
    }
    
    /**
     * constructor with no parameters
     */
    MovieGenre () {
        setGenreId(new Long(0));
        setMovieId(new Long(0));
    }
    
    /**
     * 
     * @param genreId Long object
     */
    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }
    
    /**
     * 
     * @param genreId primitive long
     */
    public void setGenreId(long genreId) {
        this.genreId = new Long(genreId);
    }
    
    /**
     * 
     * @param genre
     */
    public void setMovieId(Long movieId) {
        this.movieId = movieId.longValue();
    }
    
    /**
     * 
     * @return genreId
     */
    public Long getGenreId() {
        return genreId;
    }
    
    /**
     * 
     * @return genre
     */
    public Long getMovieId() {
        return movieId;
    }
    
    /**
     * update existing tuples in table. Does not check if genreId exists (yet?)
     * @throws SQLException
     */
    public void update() throws SQLException {
        boolean ok = false;
        
        String SQL = "UPDATE Genre SET Genre = ? WHERE GenreId = ?";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            stmt.setString(1, genre);
            stmt.setLong(2, genreId);
            
            int n = stmt.executeUpdate();
            ConnectionManager.getConnection().commit();
            ok = true;
            
            System.out.println("Updates made: " + n);
        } finally {
            if (!ok) {
                ConnectionManager.getConnection().rollback();
            }
        }
    }
    
    /**
     * deletes existing tuples in table. Does not check if genreId exists (yet?)
     * @throws SQLException
     */
    public void delete() throws SQLException {
        boolean ok = false;
        
        String SQL = "DELETE FROM Genre WHERE GenreId = ?";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            stmt.setLong(1, genreId);
            
            int n = stmt.executeUpdate();
            ConnectionManager.getConnection().commit();
            ok = true;
            
            System.out.println("Deletions made: " + n);
        } finally {
            if (!ok) {
                ConnectionManager.getConnection().rollback();
            }
        }
    }
}
