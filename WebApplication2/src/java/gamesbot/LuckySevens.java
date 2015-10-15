package gamesbot;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */


public class LuckySevens {
    
    private int bet;
    private String output;

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
    
    
    public Random r;
    public String run() {
        
        
        int bet = 0, accountTotal = 0, numOfRolls =0, maxMoneyRolls = 0, accountMax =0;
        
        Scanner scan = new Scanner(System.in);
        r = new Random();
        
        System.out.println("How many dollars do you have to bet?");
        bet = scan.nextInt();
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
        } while (accountTotal != 0); 
        
        output = "It took "+numOfRolls+" rolls for you to lose. Well done. Your greatest total was "+accountMax+" at "+maxMoneyRolls+" rolls.";
        return output;
    }
    
    public int rollDice() {
        int dice1 = 1+ r.nextInt(6);
        int dice2 = 1+ r.nextInt(6);
        System.out.println("Dice #1 = "+dice1+" Dice #2 = "+dice2);
        return dice1 + dice2;
    }
}
