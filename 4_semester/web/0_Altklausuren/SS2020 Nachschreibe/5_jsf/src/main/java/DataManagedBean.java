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
    private int km;
    private int minuten;
    private int sekunden;
    
    /**
     * Creates a new instance of DataManagedBean
     */
    public DataManagedBean() {
    }
    
    public int getKm() {
        return km;
    }
    
    public int getMinuten() {
        return minuten;
    }
    
    public int getSekunden() {
        return sekunden;
    }
    
    public void setKm(int km) {
        this.km = km;
    }
    
    public void setMinuten(int minuten) {
        this.minuten = minuten;
    }
    
    public void setSekunden(int sekunden) {
        this.sekunden = sekunden;
    }
    
    public double getErgebnis() {
        return (double) (minuten * 60 + sekunden) / km / 60;
    }
}
