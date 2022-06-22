/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import backend.BMIcaclulator;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author dunkel
 */
@Named(value = "handler")
@RequestScoped
public class EventHandler {

    public Date today() {
        return new Date();
    }

    public String clickBmi(Person data) {
        BMIcaclulator calculator = BMIcaclulator.singleton();
        double bmi = calculator.calculateBMI(data.getWeight(),data.getHeight());
        data.setBmi(bmi);
        return "bmiResult.xhtml";
    }

    public String createMessage(Person data) {
       BMIcaclulator calculator = BMIcaclulator.singleton();
       return calculator.bmiMessage(data.getWeight(), data.getHeight());
    }
    
    public double getMaxBmi(){
        BMIcaclulator calculator = BMIcaclulator.singleton();
        return calculator.getMaxBMI();
    }


    

}
