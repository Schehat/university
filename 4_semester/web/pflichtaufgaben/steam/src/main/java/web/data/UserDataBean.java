/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package web.data;

import de.hsh.steam.services.SteamService;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Named;

/**
 *
 * @author lushaj
 */
@Named(value = "userDataBean")
@SessionScoped
public class UserDataBean implements Serializable  {
    
    private String username;
    private String password;

    /**
     * Creates a new instance of UserDataBean
     */
    public UserDataBean() { }

    public String getUsername() {
        System.out.println("Getter: "+ this.username);
        System.out.println("obj: "+ this);
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
        System.out.println("Setter: "+ this.username);
        System.out.println("obj: "+ this);
    }
    
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String login() {
        SteamService steamservice = SteamService.getInstance();
        steamservice.dumpRepository();
        System.out.println("obj: "+ this);
        System.out.println("Username and pw in login(): " + username + " " + password);
        
        System.out.println("boolean if login true: "+ steamservice.login(username, password)) ;

        if (steamservice.login(username, password)) {
            return "series.xhtml";
        } else {
            return null;
        }
    }
    
}