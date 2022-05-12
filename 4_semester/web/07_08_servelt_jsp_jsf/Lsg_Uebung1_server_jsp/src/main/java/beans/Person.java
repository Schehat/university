/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author dunkel
 */
public class Person {
    String weight;
    String height;
    
    public Person(String weight, String height){
        this.weight = weight;
        this.height = height;
    }
    
    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
    
    public String sayBMI(){
        String result = "";
        try{
            float weightValue = Float.parseFloat(weight);
            float heightValue = Float.parseFloat(height);
            float BMI = weightValue / (heightValue * heightValue);
            
            String weightClass = "Normalgewicht";
            if(BMI < 19.0) {
                weightClass = "Untergewicht";
            }
            if(BMI > 25.0) {
                weightClass = "Übergewicht";
            }
            result += "Dein BMI ist: " + Math.round(BMI)
                    + " !!!! du hast " 
                    + weightClass 
                    + ".";
            
        } catch (NumberFormatException e) {
            result = "Nur numerische Werte eingeben!";
        } catch (IllegalArgumentException e) {
            result = "Ungültige Werte!";
        }
        return result;
    }
    
}

