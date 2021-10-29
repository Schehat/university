import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author Schehat
 * Genre record
 */
public class Genre {
    private Long genreId;
    private String genre;
    
    /**
     * constructor with parameters & Long object
     * @param genreId
     * @param genre
     */
    Genre (Long genreId, String genre) {
        setGenreId(genreId);
        setGenre(genre);
    }
    
    /**
     * constructor with parameters & primitive data type long
     * @param genreId
     * @param genre
     */
    Genre (long genreId, String genre) {
        setGenreId(new Long(genreId));
        setGenre(genre);
    }
    
    /**
     * constructor with no parameters
     */
    Genre () {
        setGenreId(new Long(0));
        setGenre("");
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
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    /**
     * 
     * @return genreId
     */
    public long getGenreId() {
        return genreId;
    }
    
    /**
     * 
     * @return genre
     */
    public String getGenre() {
        return genre;
    }
    
    /**
     * insert Genre object to table 
     * @throws SQLException
     */
    public void insert() throws SQLException {
        // if genreId = 0 this means no custom id was set thus using a sequence
        if (genreId.longValue() == 0) {
            String getSeq = "SELECT genre_seq.nextval FROM DUAL";
            try (PreparedStatement seq = ConnectionManager.getConnection().prepareStatement(getSeq)) {
                ResultSet rs = seq.executeQuery();
                rs.next();
                genreId = rs.getLong("nextval");
            } 
        }
        
        String SQL = "INSERT INTO Genre VALUES (?, ?)";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            stmt.setLong(1, genreId);
            stmt.setString(2, genre);
            
            int n = stmt.executeUpdate();
            System.out.println("Inserts made: " + n);
        }
    }
    
    /**
     * update existing tuples in table. Does not check if genreId exists (yet?)
     * @throws SQLException
     */
    public void update() throws SQLException {
        String SQL = "UPDATE Genre SET Genre = ? WHERE GenreId = ?";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            stmt.setString(1, genre);
            stmt.setLong(2, genreId);
            
            int n = stmt.executeUpdate();           
            System.out.println("Updates made: " + n);
        }
    }
    
    /**
     * deletes existing tuples in table. Does not check if genreId exists (yet?)
     * @throws SQLException
     */
    public void delete() throws SQLException {
        String SQL = "DELETE FROM Genre WHERE GenreId = ?";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            stmt.setLong(1, genreId);
            
            int n = stmt.executeUpdate();
            System.out.println("Deletions made: " + n);
        } 
    }
}
