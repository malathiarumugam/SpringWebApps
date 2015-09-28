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

            while (file.hasNextLine()) {
                currentLine = file.nextLine();
                split = currentLine.split(",");
                tree.put(split[0], Double.parseDouble(split[1]));
            }
            file.close();
        } catch (FileNotFoundException e) {
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

            while (file.hasNextLine()) {
                currentLine = file.nextLine();
                split = currentLine.split(",");
                tree.add(split[0]);
                tree.add(split[1]);
                tree.add(split[2]);
            }
            file.close();
        } catch (FileNotFoundException e) {
            //either makes a populated or empty address book
        }
        return tree;
    }

    public ArrayList<String> readUSA(String filename) {
        ArrayList<String> USA = new ArrayList();
        try {
            Scanner file = new Scanner(new BufferedReader(new FileReader(filename)));
            String currentLine = "";
            String[] split;

            while (file.hasNextLine()) {
                currentLine = file.nextLine();
                split = currentLine.split("::");
                for (int i = 0; i < split.length; i++) {
                    USA.add(split[i]);
                }
            }
            file.close();
        } catch (FileNotFoundException e) {
            
        }
        return USA;
    }

    //reads a file with an order or orders
    public ArrayList<String> readOrder(String filename) {
        ArrayList<String> order = new ArrayList();
        try {
            Scanner file = new Scanner(new BufferedReader(new FileReader(filename)));
            String currentLine = "";
            while (file.hasNextLine()) {
                currentLine = file.nextLine();
                order.add(currentLine);
            }
            file.close();
        } catch (FileNotFoundException e) {
            //either makes a populated or empty address book
        }
        return order;
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
