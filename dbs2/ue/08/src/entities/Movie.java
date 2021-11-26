package entities;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "ue08Movie")
public class Movie {

    @Version
    @Id
    @Column(name = "movieId") @GeneratedValue
    private Long movieId;
    
    @Column(name = "title", nullable = false)
    private String title;
    
    @Column(name = "year")
    private Integer year;
    
    @Column(name = "type")
    private String type;
    
    @ManyToMany(mappedBy = "movies", cascade = CascadeType.PERSIST)
    private ArrayList<Genre> genres = new ArrayList<Genre>();
    
    @OneToMany(mappedBy = "movie", cascade = CascadeType.PERSIST)
    private ArrayList<MovieCharacter> movChars = new ArrayList<MovieCharacter>();
    
    /**
     * constructor with parameters
     * @param movieId
     * @param title
     * @param year
     * @param type
     */
    public Movie (Long movieId, String title, Integer year, String type, ArrayList<Genre> genres, 
            ArrayList<MovieCharacter> movChars) {
        setMovieId(movieId);
        setTitle(title);
        setYear(year);
        setType(type);
        setGenres(genres);
        setMovChars(movChars);
    }
    
    /**
     * empty constructor
     */
    public Movie() {
        
    }
    
    /**
     * 
     * @param movieId
     */
    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
    
    /**
     * 
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * 
     * @param year
     */
    public void setYear(Integer year) {
        this.year = year;
    }
    
    /**
     * 
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }
    
    /**
     * 
     * @param genres
     */
    public void setGenres(ArrayList<Genre> genres) {
        this.genres = (ArrayList<Genre>) genres.clone();
    }
    
    
    public void setMovChars(ArrayList<MovieCharacter> movChars) {
        this.movChars = (ArrayList<MovieCharacter>) movChars.clone();
    }
    
    /**
     * 
     * @return movieId
     */
    public Long getMovieId() {
        return movieId;
    }
    
    /**
     * 
     * @return title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * 
     * @return year
     */
    public Integer getYear() {
        return year;
    }
    
    /**
     * 
     * @return type
     */
    public String getType() {
        return type;
    }
    
    /**
     * 
     * @return genres
     */
    public ArrayList<Genre> getGenres() {
        return genres;
    }
    
    /**
     * 
     * @return movChars
     */
    public ArrayList<MovieCharacter> getMovChars() {
        return movChars;
    }
}
