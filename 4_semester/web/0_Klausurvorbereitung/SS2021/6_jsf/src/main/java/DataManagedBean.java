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
    private double dollar;
    private double faktor;
    
    /**
     * Creates a new instance of DataManagedBean
     */
    public DataManagedBean() {
    }
    
    public double getDollar() {
        return dollar;
    }
    
    public double getFaktor() {
        return faktor;
    }
    
    public void setDollar(double dollar) {
        this.dollar = dollar;
    }
    
    public void setFaktor(double faktor) {
        this.faktor = faktor;
    }
    
    public double getEuro() {
        return dollar * faktor;
    }
}
