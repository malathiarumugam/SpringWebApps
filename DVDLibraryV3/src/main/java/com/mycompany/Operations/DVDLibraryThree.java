package com.mycompany.Operations;

import com.swcguild.dvdlibrary.dao.DvdLibraryDao;

import com.swcguild.dvdlibrary.dto.DVD;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DVDLibraryThree implements DvdLibraryDao {
    private List<DVD> userCollection;
    
    public DVDLibraryThree(){
        userCollection = new ArrayList<>();
    }
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
    public void add(DVD d){
        userCollection.add(d);
    }
    
    
    @Override
    public void remove(int id){
        DVD temp = null;
        for(DVD d : userCollection){
            if(d.getId() == id){
                temp = d;
            }
        }
        userCollection.remove(temp);
    }
    
    @Override
    public DVD getById(int id){
        DVD temp = null;
        for(DVD d : userCollection){
            if(d.getId() == id){
                temp = d;
            }
        }
        return temp;
    }
    
    @Override
    public List<DVD> listAll(){
        return userCollection;
    }
    
    @Override
    public List<DVD> getByTitle(String title){
        List<DVD> results = null;
        results = userCollection.stream()
                                .filter(s -> s.getTitle().equalsIgnoreCase(title))
                                .collect(Collectors.toList());
        return results;
    }

    @Override
    public List<DVD> getByRating(String rating) {
        List<DVD> results = null;
        results = userCollection.stream()
                                .filter(s -> s.getMpaaRating().equalsIgnoreCase(rating))
                                .collect(Collectors.toList());
        return results;
    }


    @Override
    public List<DVD> getByStudio(String studio) {
        List<DVD> results = null;
        results = userCollection.stream()
                                .filter(s -> s.getStudio().equalsIgnoreCase(studio))
                                .collect(Collectors.toList());
        return results;
    }
}

