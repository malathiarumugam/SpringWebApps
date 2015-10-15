/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamecode;

import java.text.DecimalFormat;

public class FlooringCalculator {
    private int length;
    private int width;
    private int unitCost;
    private String output;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(int unitCost) {
        this.unitCost = unitCost;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
    
    public String run() {
        
        
        float area = length * width;
        float perimeter = length*2 + width*2;
        
        DecimalFormat df = new DecimalFormat("#.00");
        
        float total = unitCost * area;
        float labor = (area/20)*86.00f;
        float billing = labor/4;
        float bill = total+labor;
        output = "The flooring material cost is $" + df.format(total) + ". <br>The cost of labor will be $"+df.format(billing)+" every 15 minutes. <br>The total bill will be $"+df.format(bill)+".";
        
        return output;
        
    }
}
