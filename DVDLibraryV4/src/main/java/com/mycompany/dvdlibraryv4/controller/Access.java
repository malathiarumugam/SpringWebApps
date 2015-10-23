package com.mycompany.dvdlibraryv4.controller;

import com.mycompany.dvdlibraryv4.model.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Access {

    //reads the state and taxrate file
    public ArrayList<String> addFromFile(String filename) {
        ArrayList<String> addresses = new ArrayList();
        try {
        String currentLine;
        Scanner file = new Scanner(new BufferedReader(new FileReader(filename)));
        while (file.hasNextLine()) {
            currentLine = file.nextLine();
            addresses.add(currentLine);
        }
            file.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        return addresses;
    }

    public void writeEntry(String filename, DVD dvdBook) {
        try {
            PrintWriter output = new PrintWriter(new FileWriter(filename));
            
            
                output.println(dvdBook.toString());
            
            output.flush();
            output.close();
        } catch (IOException e) {
            System.out.println("File Write failed: " + e.getMessage());
        }
    }

}
