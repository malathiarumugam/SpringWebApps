


package gamecode;

import java.text.DecimalFormat;


public class UnitConverter {
    private String userFromChoice; 
    private String userToChoice;
    private double userTemp;

    public double getUserTemp() {
        return userTemp;
    }

    public void setUserTemp(double userTemp) {
        this.userTemp = userTemp;
    }

    public String getUserFromChoice() {
        return userFromChoice;
    }

    public void setUserFromChoice(String userFromChoice) {
        this.userFromChoice = userFromChoice;
    }

    public String getUserToChoice() {
        return userToChoice;
    }

    public void setUserToChoice(String userToChoice) {
        this.userToChoice = userToChoice;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
    private String output;

    public String run() {
        double tempInFahrenheit = 0;
        double tempInCelsius = 0;
        double tempInKelvin = 0;
        DecimalFormat df = new DecimalFormat("#.00");
        
        if (userToChoice.equals("Fahrenheit")){
            if (userFromChoice.equals("Celsius")){
                tempInFahrenheit = userTemp * 1.8 + 32;
               output = "The temperature in Fahrenheit is " + df.format(tempInFahrenheit) + ".";
            } else if (userFromChoice.equals("Kelvin")){
                tempInFahrenheit = userTemp * 9/5 -459.67;
                output = "The temperature in Fahrenheit is " + df.format(tempInFahrenheit) + ".";
            } else {
                output = "Nothing to convert, silly.";
            }
        }
        if (userToChoice.equals("Celsius")){
            if (userFromChoice.equals("Fahrenheit")){
                tempInCelsius = (userTemp - 32) / 1.8;
                output = "The temperature in Celsius is " + df.format(tempInCelsius) + ".";
            } else if (userFromChoice.equals("Kelvin")){
                tempInCelsius = userTemp - 273.15;
                output = "The temperature in Celsius is " + df.format(tempInCelsius) + ".";
            } else {
                output = "Nothing to convert, silly.";
            }
        }
        if (userToChoice.equals("Kelvin")){
            if (userFromChoice.equals("Fahrenheit")){
                tempInKelvin = (userTemp + 459.67) * 5/9;
                output = "The temperature in Kelvin is " + df.format(tempInKelvin) + ".";
            } else if (userFromChoice.equals("Celsius")){
                tempInKelvin = userTemp + 273.15;
                output = "The temperature in Kelvin is " + df.format(tempInKelvin) + ".";
            } else {
                output = "Nothing to convert, silly.";
            }
        }
        
        
        return output;
    }
}
