package com.mycompany.dao;

import com.swcguild.dvdlibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class FileIO {
    
  ///////////////////////////////////////////////
    
    public ArrayList<DVD> readDVDs(String filename) {
        ArrayList<DVD> dvds = new ArrayList();
        try {
            Scanner file = new Scanner (new BufferedReader(new FileReader(filename)));
            String line;
            String [] splitLine;
            while (file.hasNextLine()){
                line = file.nextLine();
                splitLine = line.split("::"); 
                DVD temp = new DVD();
                        temp.setTitle(splitLine[0]);
                        
                        temp.setReleaseDate(LocalDate.parse(splitLine[1]));
                        temp.setMpaaRating(splitLine[2]);
                        temp.setDirector(splitLine[3]);
                        temp.setStudio(splitLine[4]);
                        temp.setNote(splitLine[5]);
                dvds.add(temp);
            }
            file.close();
        }
        catch(FileNotFoundException e) {
            //either makes a populated or empty dvd library
            return dvds;
        }
        return dvds;   
    }
 
    public void writeDVDs(String filename, ArrayList<DVD> dvds) {
        try {
            PrintWriter output = new PrintWriter(new FileWriter(filename));
            String outString;
            DVD element;
            Iterator<DVD> iter = dvds.iterator();
            while (iter.hasNext()) {
                element = iter.next();
                outString = element.getTitle() + "::"
                        + element.getReleaseDate() + "::"
                        + element.getMpaaRating()+ "::"
                        + element.getDirector() + "::"
                        + element.getStudio() + "::"
                        + element.getNote();
                output.println(outString);
                outString = "";
            }
        output.flush();
        output.close();
        } catch (IOException e) {
            System.out.println("File Write failed: " + e.getMessage());
        }
    }
}


