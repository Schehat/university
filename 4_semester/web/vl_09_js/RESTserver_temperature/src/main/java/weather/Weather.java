/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dunkel
 */
@XmlRootElement
public class Weather {
    String location;
    double temperature;
    
    //getter/ setter und constructors:
    
    public Weather(String location, double temperature) {
        this.location = location;
        this.temperature = temperature;
    }

    public Weather() {
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    
    public String toString(){
        return "Location:" + this.location + "  Temperature:" + this.temperature;
    }
    
}
