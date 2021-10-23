import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Genre {
    private long genreId;
    private String genre;
    
    Genre (long genreId, String genre) {
        this.genreId = genreId;
        this.genre = genre;
    }
    
    public void setGenreId(long genreId) {
        this.genreId = genreId;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public long getGenreId() {
        return genreId;
    }
    
    public String getGenre() {
        return genre;
    }
    
    public void insert() throws SQLException {
        boolean ok = false;
        
        if (genreId == 0) {
            String getSeq = "SELECT genre_seq.nextval FROM DUAL";
            try (PreparedStatement seq = ConnectionManager.getConnection().prepareStatement(getSeq)) {
                ResultSet rs = seq.executeQuery();
                rs.next();
                genreId = rs.getLong("nextval");
            } finally {  // dieses rollback setzt nur die Sequenz zurück
                if (!ok) {
                    ConnectionManager.getConnection().rollback();
                }
            }
        }
        
        String SQL = "INSERT INTO Genre VALUES (?, ?)";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            stmt.setLong(1, genreId);
            stmt.setString(2, genre);
            
            int n = stmt.executeUpdate();
            ConnectionManager.getConnection().commit();
            
            System.out.println("Inserts made: " + n);
        } finally {
            if (!ok) {
                ConnectionManager.getConnection().rollback();
            }
        }
    }
    
    public void update() throws SQLException {
        boolean ok = false;
        
        String SQL = "UPDATE Genre SET Genre = ? WHERE GenreId = ?";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            stmt.setString(1, genre);
            stmt.setLong(2, genreId);
            
            int n = stmt.executeUpdate();
            ConnectionManager.getConnection().commit();
            
            System.out.println("Updates made: " + n);
        } finally {
            if (!ok) {
                ConnectionManager.getConnection().rollback();
            }
        }
    }
    
    public void delete() throws SQLException {
        boolean ok = false;
        
        String SQL = "DELETE FROM Genre WHERE GenreId = ?";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            stmt.setLong(1, genreId);
            
            int n = stmt.executeUpdate();
            ConnectionManager.getConnection().commit();
            
            System.out.println("Deletions made: " + n);
        } finally {
            if (!ok) {
                ConnectionManager.getConnection().rollback();
            }
        }
    }
}
