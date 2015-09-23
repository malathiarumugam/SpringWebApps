
package UI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    Scanner kb = new Scanner(System.in);
    public int readInteger(String p) {
        boolean failed;
        int ret = 0;
        do {
            failed = false;
            System.out.println(p);
            try {
                ret = kb.nextInt();
                kb.nextLine();
            } 
            catch (InputMismatchException e) {
               System.out.println("Input must be an integer."); 
               failed = true;
            }
        }while (failed);
        return ret;
    }
    
    public int readInteger(String p, int min, int max) {
        boolean failed;
        int ret = 0;
        do {
            failed = false;
            System.out.println(p);
            try {
                ret = kb.nextInt();
                if(ret < min || ret > max) {
                    System.out.println("Value must be between " + min 
                            + " and " + max + ".");
                }
            } 
            catch (InputMismatchException e) {
               System.out.println("Input must be an integer."); 
               failed = true;
            } finally {
                kb.nextLine();
            }
        }while (failed || ret < min || ret > max);
        
        return ret;

    }
    
    public String readString(String p) {
        System.out.println(p);
        String z = kb.nextLine();
        return z;
    }
    
    public float readFloat(String p) {
        boolean failed;
        float ret = 0;
        do {
            failed = false;
            System.out.println(p);
            try {
                ret = kb.nextFloat();
            } 
            catch (InputMismatchException e) {
               System.out.println("Input must be a number."); 
               failed = true;
            }
        }while (failed);
        return ret;
    }  
    
    public float readFloat(String p, float min, float max) {
        boolean failed;
        float ret = 0;
        do {
            failed = false;
            System.out.println(p);
            try {
                ret = kb.nextFloat();
                if(ret < min || ret > max) {
                    System.out.println("Value must be between " + min 
                            + " and " + max + ".");
                }
            } 
            catch (InputMismatchException e) {
               System.out.println("Input must be a number."); 
               failed = true;
            }
        }while (failed || ret < min || ret > max);
        
        return ret;
    }
    
    public double readDouble(String p) {
        boolean failed;
        double ret = 0;
        do {
            failed = false;
            System.out.println(p);
            try {
                ret = kb.nextDouble();
            } 
            catch (InputMismatchException e) {
               System.out.println("Input must be a number."); 
               failed = true;
            }
        }while (failed);
        return ret;
    }
    
    public double readDouble(String p, double min, double max) {
        boolean failed;
        double ret = 0;
        do {
            failed = false;
            System.out.println(p);
            try {
                ret = kb.nextDouble();
                if(ret < min || ret > max) {
                    System.out.println("Value must be between " + min 
                            + " and " + max + ".");
                }
            } 
            catch (InputMismatchException e) {
               System.out.println("Input must be a number."); 
               failed = true;
            }
        }while (failed || ret < min || ret > max);
        
        return ret;
    }
    
    public double readDoubleMat(String p, double min, double max) {
        boolean failed;
        double ret = 0;
        do {
            failed = false;
            System.out.println(p);
            try {
                ret = kb.nextDouble();
                if(ret < min) {
                    System.out.println("You have to at least order one square foot.");
                } else  if (ret > max) {
                    System.out.println("We do not have that much in stock. That is a ridiculous amount!");
                }
            } 
            catch (InputMismatchException e) {
               System.out.println("Input must be a number."); 
               failed = true;
            }
        }while (failed || ret < min || ret > max);
        
        return ret;
    }
    
    public void write(String p) {
        System.out.print(p);
    }
    
}
