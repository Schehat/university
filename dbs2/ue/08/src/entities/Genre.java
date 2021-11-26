package entities;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "ue08Genre")
public class Genre {

    @Version
    @Id
    @Column(name = "genreId") @GeneratedValue
    private Long genreId;
    
    @Column(name = "genre", unique = true)
    private String genre;
    
    @ManyToMany
    @JoinTable(name = "movieGenre")
    private ArrayList<Movie> movies = new ArrayList<Movie>();
    
    /**
     * constructor with parameters
     * @param genreId
     * @param genre
     */
    public Genre (Long genreId, String genre, ArrayList<Movie> movies) {
        setGenreId(genreId);
        setGenre(genre);
        setMovies(movies);
    }
    
    /*
     * empty constructor
     */
    public Genre() {
        
    }
    
    /**
     * 
     * @param genreId
     */
    public void setGenreId(Long genreId) {
        this.genreId = genreId;
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
     * @param movies
     */
    public void setMovies(ArrayList<Movie> movies) {
        this.movies = (ArrayList<Movie>) movies.clone();
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
    public String getGenre() {
        return genre;
    }
    
    /**
     * 
     * @return movies
     */
    public ArrayList<Movie> getMovies() {
        return movies;
    }
   
}
