


package gamecode;

import java.util.Random;

public class LuckySevens {
    
    private String betIn;

    public String getBetIn() {
        return betIn;
    }

    public void setBetIn(String betIn) {
        this.betIn = betIn;
    }
    private String output;
    private String error;
    private int bet;
    private String status;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public void testNum() {    
    try {
            bet = Integer.parseInt(betIn);
         }
         catch(NumberFormatException e) {
             error = ("You haven't entered a dollar amount.  Please try again.");
             setStatus("2");
             return;
         }
         
         if(bet < 0) {
             error = ("Clever, but you can't rig the game by betting a negative amount. Please try again.");
             setStatus("2");
             return;
         }
    }
    public int getBet() {
        return bet;
    }

    public void setBet(String bet) {
        
        this.bet = Integer.parseInt(bet);
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
    
    
    public Random r;
    public String findName() {
            return "LuckySevens";
    }
    
    public void run() {
        
        int accountTotal = 0, numOfRolls =0, maxMoneyRolls = 0, accountMax =0;
        
        r = new Random();
        
        
        accountTotal += bet;
        System.out.println("Lets Play!");
        do {
            
            if(rollDice() == 7) {
                accountTotal += 4;
                System.out.println("You win +$4");
                System.out.println("Account total: "+accountTotal);
            } else {
                accountTotal -= 1;
                System.out.println("You lose -$1");
                System.out.println("Account total: "+accountTotal);
            }
            numOfRolls++;
            if (accountTotal > accountMax) {
                 accountMax = accountTotal;
                 maxMoneyRolls =numOfRolls;
            }
        } while (accountTotal > 0); 
        output = "It took "+numOfRolls+" rolls for you to lose. Well done. Your greatest total was "+accountMax+" at "+maxMoneyRolls+" rolls.";
    }
    
    public int rollDice() {
        int dice1 = 1+ r.nextInt(6);
        int dice2 = 1+ r.nextInt(6);
        System.out.println("Dice #1 = "+dice1+" Dice #2 = "+dice2);
        return dice1 + dice2;
    }
}

