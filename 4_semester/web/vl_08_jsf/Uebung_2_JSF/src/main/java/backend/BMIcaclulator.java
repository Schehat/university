/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author dunkel
 */
public class BMIcaclulator {

    private static double maxBMI = 0;

    private static BMIcaclulator exemplar = null;
    public static BMIcaclulator singleton() {
        if (exemplar == null) {
            exemplar = new BMIcaclulator();
        }
        return exemplar;
    }

    public double calculateBMI(double weight, double height) {
        double bmi = weight / (height * height);
        if (bmi > maxBMI) {
            maxBMI = bmi;
        }
        return bmi;
    }

    public String bmiMessage(double weight, double height) {
        double bmi = weight / (height * height);
        if (bmi < 18) {
            return "Du hast Untergewicht";
        }
        if (bmi > 26) {
            return "Du hast Übergewicht";
        }
        return "Du hast Normalgewicht";
    }

    public double getMaxBMI() {
        return maxBMI;
    }

}
