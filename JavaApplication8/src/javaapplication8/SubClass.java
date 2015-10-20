


package javaapplication8;

class Superclass {
   public void printMethod() {
       System.out.println("SUPER ");
   } 
   
   Superclass() {
       System.out.println("SUPER DUPER");
   }
}


public class SubClass extends Superclass {
    
    SubClass() {
        System.out.println("SUB SUB");
    }

    // overrides printMethod in Superclass
    public void printMethod() {
        super.printMethod();
        System.out.println("Printed in Subclass");
        super.printMethod();
    }
    
    public static void main(String[] args) {
        SubClass s = new SubClass();
        new Superclass();
        
    }
}
