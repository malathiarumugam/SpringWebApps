package com.mycompany.Operations;

import com.swcguild.dvdlibrary.dao.DvdLibraryDao;
import com.swcguild.dvdlibrary.dto.DVD;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class DVDCollection implements DvdLibraryDao {
    
    private ArrayList<DVD> dvdCollection = new ArrayList<>();
    
    @Override
    public void add(DVD temp) {
        dvdCollection.add(temp);
    }
    
    @Override
    public void remove(int index) {
        
        dvdCollection.remove(dvdCollection.get(index));
        
    }

    @Override
    public ArrayList getAllDVD() {
        System.out.println("Christmas@@!!!!");
        return new ArrayList();
    }

    @Override
    public DVD findDVD(String string) {
        System.out.println("new Suits!");
        return new DVD();
    }

    @Override
    public int findDVDCount(String string) {
        System.out.println("Christmans sweats");
        return 7;
    }

    @Override
    public List<DVD> listAll() {
        return dvdCollection;
    }
    
    @Override
    public DVD getById(int id) {
       return dvdCollection.stream().filter(x -> x.getId()==id).collect(Collectors.toList()).get(0);
    }
    
    @Override
    public List<DVD> getByTitle(String title) {
        List<DVD> temp = new ArrayList();
        dvdCollection.stream().filter((dvdCollection1) -> (dvdCollection1.getTitle().equals(title))).forEach((dvdCollection1) -> {
            temp.add(dvdCollection1);
        });
        return temp;
    }
    
    @Override
    public List<DVD> getByRating(String rating) {
        
        List<DVD> temp = new ArrayList();
        dvdCollection.stream().filter((dvdCollection1) -> (dvdCollection1.getMpaaRating().equals(rating))).forEach((dvdCollection1) -> {
            temp.add(dvdCollection1);
        });
        return temp;
    }
    
    @Override
    public List<DVD> getByStudio(String studio) {
        List<DVD> temp = new ArrayList();
        dvdCollection.stream().filter((dvdCollection1) -> (dvdCollection1.getStudio().equals(studio))).forEach((dvdCollection1) -> {
            temp.add(dvdCollection1);
        });
        return temp;
    }
    
//    public ArrayList retrieveMultiple(String title) {
//        ArrayList<Dvd> temp = new ArrayList<>();
//        dvdCollection.stream().filter((dvdCollection1) -> (title.equals(dvdCollection1.getTitle()))).forEach((dvdCollection1) -> {
//            temp.add(dvdCollection1);
//        });
//        return temp;
//    }
//    
//    public int getNumTitle(String title) {
//        int count = 0;
//        count = dvdCollection.stream().filter((dvdCollection1) -> (title.equals(dvdCollection1.getTitle()))).map((_item) -> 1).reduce(count, Integer::sum);
//        return count;
//    }
//    
//    public double getAvgAge() {
//        
//        return dvdCollection.stream().mapToDouble(Dvd::getAge).average().getAsDouble();
//        
//    }
//    
//    public double getAvgComments() {
//        
//        return dvdCollection.stream().mapToLong(Dvd::getNumComments).average().getAsDouble();
//        
//    }
//    
//    public Dvd oldestMovie() {
//        int oldest = 0;
//        if (dvdCollection.isEmpty()) {
//            return null;
//        }
//        for (int i = 0; i < dvdCollection.size(); i++) {
//            
//            if (dvdCollection.get(i).getAge() > oldest) {
//                oldest = i;
//            }
//            
//        }
//        return dvdCollection.get(oldest);
//        
//    }
//    
//    public Dvd newestMovie() {
//        int newest = Integer.MAX_VALUE;
//        
//        if (dvdCollection.isEmpty()) {
//            return null;
//        }
//        
//        for (int i = 0; i < dvdCollection.size(); i++) {
//            
//            if (dvdCollection.get(i).getAge() < newest) {
//                newest = i;
//            }
//            
//        }
//        return dvdCollection.get(newest);
//        
//    }
    
    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < dvdCollection.size(); i++) {
            
            temp += "Number: " + (i + 1)
                    + "\nTitle: " + dvdCollection.get(i).getTitle()
                    + "\nRelease Date: " + dvdCollection.get(i).getReleaseDate()
                    + "\nMPAA Rating: " + dvdCollection.get(i).getMpaaRating()
                    + "\nDirectors Name: " + dvdCollection.get(i).getDirector()
                    + "\nStudio: " + dvdCollection.get(i).getStudio()
                    + "\nUser Rating: " + dvdCollection.get(i).getNote();
        }
        return temp;
    }


    
}
