/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package web.event;

import jakarta.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author SAbde
 */
@Named(value = "userEventNavigator")
@RequestScoped
public class UserEventNavigator {

    /**
     * Creates a new instance of UserEventBean
     */
    public UserEventNavigator() {
    }
    
    public String toHomepage() {
        return "series.xhtml";
    }
    
}
