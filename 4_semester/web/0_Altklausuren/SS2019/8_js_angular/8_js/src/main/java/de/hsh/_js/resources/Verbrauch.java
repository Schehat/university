package de.hsh._js.resources;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SAbde
 */
@XmlRootElement
public class Verbrauch {
    private double verbrauch;
    
    public Verbrauch() {
        
    }
    
    public double getVerbrauch() {
        return verbrauch;
    }
    
    public void setVerbrauch(double verbrauch) {
        this.verbrauch = verbrauch;
    }
}

