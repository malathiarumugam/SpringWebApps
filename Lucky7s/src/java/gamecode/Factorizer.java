
package gamecode;


public class Factorizer {
    
    private double answer;
    private String output = "Factors: ";

    public double getAnswer() {
        return answer;
    }

    public void setAnswer(double answer) {
        this.answer = answer;
    }
    
    public String run() {
        
        
        int sum =0;
        
        System.out.println("The factors of "+answer+" are: ");
        for (int i = 1; i < answer; i++) {
            double quotient = answer/i; 
            if (quotient%1 == 0 ) {
                output += quotient+", ";
                sum += i;
            }
          // output += sum;
        }
        if (sum == 1) {
            output += " . \n"+answer+" is a prime number";
        } else {
            output += " . \n"+answer+" is a perfect number";
        }
        return output;
    }
 
}
