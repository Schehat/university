/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package web.event;

import de.hsh.steam.services.SteamService;
import jakarta.enterprise.context.RequestScoped;
import javax.inject.Named;
import web.data.UserDataBean;

/**
 *
 * @author lushaj
 */
@Named(value = "userEventNavigator")
@RequestScoped
public class UserEventNavigator {

    SteamService steamservice = SteamService.getInstance();

    /**
     * Creates a new instance of UserEventNavigator
     */
    public UserEventNavigator() {
    }

    public String toHomepage() {
        return "series.xhtml";
    }

    public String register(UserDataBean u) {
//        boolean usernameavailable = steamservice.newUser(u.getUsername(), u.getPassword());
//        if(usernameavailable) {
//            return "series.xhtml";
//        } else { 
//            return null;
//        }
        return "series.xhtml";

    }

    public String login(UserDataBean u) {
        System.out.println(u.getUsername() + u.getPassword() + steamservice.login(u.getUsername(), u.getPassword()));
        if (steamservice.login(u.getUsername(), u.getPassword())) {
            return "series.xhtml";
        } else {
            return null;
        }
    }

}
