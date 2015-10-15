/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamecode;

import java.text.DecimalFormat;
    
/**
 *
 * @author apprentice
 */
public class TipCalculator {
    private float bill;
    private float percentTip;

    public float getBill() {
        return bill;
    }

    public void setBill(float bill) {
        this.bill = bill;
    }

    public float getPercentTip() {
        return percentTip;
    }

    public void setPercentTip(float percentTip) {
        this.percentTip = percentTip;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
    private String output;
    
    public String run() {
        
        float tip = (percentTip/100)*bill;
        float total = tip + bill;
        
        DecimalFormat df = new DecimalFormat("#.00");
        
    output = "Output: <br>Amount: $"+bill+"<br>Tip: $"+df.format(tip)+"<br>Total: $"+df.format(total);
    return output;
    }
}
