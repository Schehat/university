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
    private double menge = 17;
    private double distanz = 100;
    
    public DataManagedBean() {
    }
    
    public double getMenge() {
        return menge;
    }
    
    public double getDistanz() {
        return distanz;
    }
    
    public void setMenge(double menge) {
        this.menge = menge;
    }
    
    public void setDistanz(double distanz) {
        this.distanz = distanz;
    }
    
    public double getVerbrauch() {
        return (menge * 100) / distanz;
    }
}
