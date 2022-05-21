/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package web.data;

import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Named;

/**
 *
 * @author SAbde
 */
@Named(value = "userDataBean")
@SessionScoped
public class UserDataBean implements Serializable  {
    
    private String username;
    private String password;

    /**
     * Creates a new instance of BeanUser
     */
    public UserDataBean() {
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
