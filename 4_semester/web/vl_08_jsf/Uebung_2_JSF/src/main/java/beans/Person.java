/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Named(value = "data")
@RequestScoped
public class Person {

    @NotNull
    @DecimalMin("40")
    @DecimalMax("140")
    private double weight = 60;
    @NotNull
    @DecimalMin("1.5")
    @DecimalMax("2.2")
    private double height = 1.75;
    
    // Ausgabefelder
    double bmi = 0.0;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }
}
