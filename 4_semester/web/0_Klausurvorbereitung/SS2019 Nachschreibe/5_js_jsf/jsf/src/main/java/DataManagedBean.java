/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author SAbde
 */
@Named(value = "dataManagedBean")
@RequestScoped
public class DataManagedBean {
    double gewicht = 70;
    double groese = 180;
    
    public DataManagedBean() {
    }
    
    public double getGewicht() {
        return gewicht;
    }
    
    public double getGroese() {
        return groese;
    }
    
    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }
    
    public void setGroese(double groese) {
        this.groese = groese;
    }
    
    public double getBmi() {
        return gewicht / (groese / 100 * groese / 100);
    }
}
