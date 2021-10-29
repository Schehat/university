import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 
 * @author Schehat
 * MovieGenre record
 */
public class MovieGenre {
    private Long genreId;
    private Long movieId;
    
    /**
     * constructor with parameters & Long object
     * @param genreId
     * @param movieId
     */
    MovieGenre (Long genreId, Long movieId) {
        setGenreId(genreId);
        setMovieId(movieId);
    }
    
    /**
     * constructor with parameters & primitive data type long
     * @param genreId
     * @param movieId
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
     * @param movieId Long object
     */
    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
    
    /**
     * 
     * @param movieId primitive long
     */
    public void setMovieId(long movieId) {
        this.movieId = new Long(movieId);
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
     * @return movieId
     */
    public Long getMovieId() {
        return movieId;
    }
    
    /**
     * insert MovieGenre object to table 
     * @throws SQLException
     */
    public void insert() throws SQLException {        
        String SQL = "INSERT INTO MovieGenre VALUES (?, ?)";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            stmt.setLong(1, genreId);
            stmt.setLong(2, movieId);
            
            int n = stmt.executeUpdate();
            System.out.println("Inserts made: " + n);
        }
    }
    
    /**
     * deletes existing tuples in table. Does not check if genreId or movieId exists (yet?)
     * @throws SQLException
     */
    public void delete() throws SQLException {
        String SQL = "DELETE FROM MovieGenre WHERE GenreId = ? AND MovieId = ?";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            stmt.setLong(1, genreId);
            stmt.setLong(2, movieId);
            
            int n = stmt.executeUpdate();
            System.out.println("Deletions made: " + n);
        }
    }
}
