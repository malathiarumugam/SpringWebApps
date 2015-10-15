
package gamecode;

import java.text.DecimalFormat;


public class InterestCalculator {
    private double entry;
    String output = "";
    
    public double getEntry() {
        return entry;
    }

    public void setEntry(double entry) {
        this.entry = entry;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
   
    
    public String run() {
        double annualIntRate = 10.0, quarterIntRate = 2.5, 
                principalAmount = entry, preInt =0, postInt;
        int yearsInFund =20;
        int quarters = yearsInFund*4;
        int startingYear = 2015;
        int currentYear = 2015;
        
        DecimalFormat df = new DecimalFormat("#.00");
        for (int i = 1; i < quarters + 1; i++) {
            if (i%4 == 1) {
            preInt = principalAmount;
            }
            postInt = principalAmount += principalAmount*(quarterIntRate/100);
            
            if (i%4 == 0) {
                currentYear++;
                System.out.println("The year is: "+currentYear);
                System.out.println("Current account value: $"+df.format(preInt));
                System.out.println("After interest value: $"+df.format(postInt));
                System.out.println("You gained $"+df.format((postInt-preInt))+" over the year.");
            }
        }
        
        output = "Your investment started out in "+startingYear+" at "+entry+".Your investment is "+df.format(principalAmount)+" after "+yearsInFund+" years in the fund.";
        
        return output;
        
    }
}
