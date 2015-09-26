


package DAO;

import Operation.Customer;
import Operation.Florable;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class Access {
    
    //reads the state and taxrate file
    public HashMap<String, Double> readTaxes(String filename) {
        HashMap<String, Double> tree = new HashMap();
        try {
            Scanner file = new Scanner(new BufferedReader(new FileReader(filename)));
            String currentLine = "";
            String[] split;
            
            while(file.hasNextLine()) {
                currentLine = file.nextLine();
                split = currentLine.split(",");
                tree.put(split[0], Double.parseDouble(split[1]));
            }
            file.close();
        }
        catch(FileNotFoundException e) {
            //either makes a populated or empty address book
        }
        return tree;   
    }
    
    //reads a file with product type, cost/sqft and labor/sqft.
    public ArrayList<String> readCost(String filename) {
        ArrayList<String> tree = new ArrayList();
        try {
            Scanner file = new Scanner(new BufferedReader(new FileReader(filename)));
            String currentLine = "";
            String[] split;
            
            while(file.hasNextLine()) {
                currentLine = file.nextLine();
                split = currentLine.split(",");
                tree.add(split[0]);
                tree.add(split[1]);
                tree.add(split[2]);
            }
            file.close();
        }
        catch(FileNotFoundException e) {
            //either makes a populated or empty address book
        }
        return tree;   
    }
    
    //reads a file with an order or orders
    public ArrayList<String> readOrder(String filename) {
        ArrayList<String> order = new ArrayList();
        try {
            Scanner file = new Scanner(new BufferedReader(new FileReader(filename)));
            String currentLine = "";
            while(file.hasNextLine()) {
                currentLine = file.nextLine();
                order.add(currentLine);
            }
            file.close();
        }
        catch(FileNotFoundException e) {
            //either makes a populated or empty address book
        }
        return order;   
    }
    
    public void writeOrder(String filename, ArrayList<Customer> orderBook) {
        try {
            PrintWriter output = new PrintWriter(new FileWriter(filename));
            String outString;
            
            Customer element = new Customer();
            
            Iterator<Customer> iter = orderBook.iterator();
            while (iter.hasNext()) {
                element = iter.next();
                HashMap<String, Florable> orderList = element.getOrderList();
                outString = element.getFirstName() + "::"
                        + element.getLastName() + "::"
                        + element.getState() + "::"
                        + element.getTaxRate() + "::";
                Set<String> keys = orderList.keySet();
                    for (String k : keys) {
                        outString += k+"::"+orderList.get(k).getProductType()+"::"+orderList.get(k).getArea()+"::"
                                +orderList.get(k).getCostPerSqFt()+"::"+orderList.get(k).getLaborPerSqFt()+"::"
                                +orderList.get(k).getMaterialCost()+"::"+orderList.get(k).getLaborCost()+"::"
                                +orderList.get(k).getTax(element.getTaxRate())+"::"
                                +orderList.get(k).getTotal(element.getTaxRate());
                    }
                output.println(outString);
                outString = "";
            }
        output.flush();
        output.close();
        } catch (IOException e) {
            System.out.println("File Write failed: " + e.getMessage());
        }
    }
    
    public void writeOrderString(String filename, ArrayList<String> orderBook) {
        try {
            PrintWriter output = new PrintWriter(new FileWriter(filename));
            for (String k : orderBook) {
                output.println(k);
            }
        output.flush();
        output.close();
        } catch (IOException e) {
            System.out.println("File Write failed: " + e.getMessage());
        }
    }
    
    
}
