
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class UI {
      Scanner kb = new Scanner(System.in);
   public int readInteger(String p) {
       boolean failed;
       int ret = 0;
       do {
           failed = false;
           System.out.print(p);
           try {
               ret = kb.nextInt();
               kb.nextLine();
           }
           catch (InputMismatchException e) {
              System.out.println("Input must be an integer.");
              failed = true;
              kb.nextLine();
           }
       }while (failed);
       return ret;
   }
   
   public int readInteger(String p, int min, int max) {
       boolean failed;
       int ret = 0;
       do {
           failed = false;
           System.out.print(p);
           try {
               ret = kb.nextInt();
               kb.nextLine();
               if(ret < min || ret > max) {
                   System.out.println("Value must be between " + min
                           + " and " + max + ".");
               }
           }
           catch (InputMismatchException e) {
              System.out.println("Input must be an integer.");
              failed = true;
              kb.nextLine();
           }
       }while (failed || ret < min || ret > max);
       
       return ret;    }
   
   public String readString(String p) {
       System.out.print(p);
       return kb.nextLine();
   }
   
   public float readFloat(String p) {
       boolean failed;
       float ret = 0;
       do {
           failed = false;
           System.out.print(p);
           try {
               ret = kb.nextFloat();
               kb.nextLine();
           }
           catch (InputMismatchException e) {
              System.out.println("Input must be a number.");
              failed = true;
              kb.nextLine();
           }
       }while (failed);
       return ret;
   } 
    
}
