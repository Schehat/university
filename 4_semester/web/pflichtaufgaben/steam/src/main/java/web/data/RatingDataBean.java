/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package web.data;

import de.hsh.steam.entities.Genre;
import de.hsh.steam.entities.Rating;
import de.hsh.steam.entities.Score;
import de.hsh.steam.entities.Streamingprovider;
import jakarta.enterprise.context.RequestScoped;
import java.util.List;
import javax.inject.Named;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 *
 * @author lushaj
 */
@Named(value = "ratingDataBean")
@RequestScoped
public class RatingDataBean {

    private String title;
    private int seasons;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @Enumerated(EnumType.STRING)
    private Streamingprovider streamingprovider;
    @Enumerated(EnumType.STRING)
    private Score score;

    private List<Rating> ratingList;

    /**
     * Creates a new instance of RatingDataBean
     */
    public RatingDataBean() {

    }

    public String getTitle() {
        return this.title;
    }
    
    public int getSeasons(){
        return this.seasons;
    }

    public Genre getGenre() {
        System.out.println("this get: " + this.genre);
        return this.genre;
    }

    public Streamingprovider getStreamingprovider() {
        return this.streamingprovider;
    }

    public Score getScore() {
        return score;
    }
    
    public List<Rating> getRatingList(){
        return this.ratingList;
    }
    
    public void setTitle(String s) {
        this.title = s;
    }
    
    public void setSeasons(int i ){
        this.seasons = i;
    }

    public void setGenre(Genre g ) {
        this.genre = g;
        System.out.println("this.genre = " + this.genre);
    }

    public void setStreamingprovider(Streamingprovider s) {
        this.streamingprovider = s;
    }

    public void setScore(Score s) {
        this.score = s;

    }
    
    public void addRatingToList(Rating r){
        this.ratingList.add(r);
    }

    public void clearList(){
        this.ratingList.clear();
    }
}