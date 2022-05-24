/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package web.event;

import de.hsh.steam.entities.Genre;
import de.hsh.steam.entities.Rating;
import de.hsh.steam.entities.Score;
import de.hsh.steam.entities.Series;
import de.hsh.steam.entities.Streamingprovider;
import de.hsh.steam.services.SteamService;
import jakarta.enterprise.context.RequestScoped;
import java.util.ArrayList;
import javax.inject.Named;
import web.data.RatingDataBean;
import web.data.UserDataBean;

/**
 *
 * @author lushaj
 */
@Named(value = "ratingEventNavigator")
@RequestScoped
public class RatingEventNavigator {
    
    SteamService steamservice = SteamService.getInstance();

    /**
     * Creates a new instance of RatingEventNavigator
     */
    public RatingEventNavigator() {
    }
    
    public void find(UserDataBean user, RatingDataBean ratingDataBean) {
        ratingDataBean.clearList(); //clearen vor der neuen operation
        
        ArrayList<Series> series = steamservice.search(user.getUsername(), ratingDataBean.getGenre(), ratingDataBean.getStreamingprovider(), ratingDataBean.getScore());
        for (Series s : series) {
            Rating r = steamservice.getRating(s.getTitle(), user.getUsername());
            if (r != null) {
                ratingDataBean.addRatingToList(r);
            }
        }
        
    }
    
    public void addSeries(UserDataBean user, RatingDataBean ratingDataBean) {
        //ratingDataBean.clearList(); //clearen vor der neuen operation
        System.out.println("genre " + ratingDataBean.getGenre());
        
        steamservice.addOrModifySeries(ratingDataBean.getTitle(), ratingDataBean.getSeasons(), ratingDataBean.getGenre(), Streamingprovider.Sky, 
                user.getUsername(), ratingDataBean.getScore(), "test");
        
    }
    
}
