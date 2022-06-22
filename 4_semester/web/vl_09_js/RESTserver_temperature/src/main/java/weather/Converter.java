/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Converter {
    double celsius;
    double fahrenheit;

    public Converter() {
    }
    
    //getter/ setter und constructors:

    
    public Converter(double celsius, double fahrenheit) {
        this.celsius = celsius;
        this.fahrenheit = fahrenheit;
    }
    
    public double getCelsius() {
        return celsius;
    }

    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }

    public double getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(double fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public String toString(){
        return "Celsius:" + this.celsius + "  Fahrenheit:" + this.fahrenheit;
    }
}
