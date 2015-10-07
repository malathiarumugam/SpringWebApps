package com.mycompany.Operations;

import com.swcguild.dvdlibrary.dao.DvdLibraryDao;
import com.swcguild.dvdlibrary.dto.DVD;
import java.util.ArrayList;
import java.util.List;

public class DVDLibrary implements DvdLibraryDao {
    private ArrayList<DVD> userCollection;
    
    public DVDLibrary(){
        userCollection = new ArrayList();
    }
    
    public DVDLibrary(ArrayList<DVD> al){
        userCollection = al;
    }
    
    @Override
    public void add(DVD d){
        userCollection.add(d);
    }
    
    @Override
    public void remove(int id){
        userCollection.remove(id);
    }
    
    public ArrayList getAllDVD(){
        return userCollection;
    }
    
    public int findDVDCount(String name){
        int counter = 0;
        for (DVD d : userCollection){
            if (d.getTitle().equals(name)){
                counter++;
                
            }
        }
        return counter;
    }
    
    public DVD findDVD(String name){
        for (DVD d : userCollection){
            if (d.getTitle().equals(name)){
                return d;
                
            }
        }
        return null;
    }

    @Override
    public List<DVD> listAll() {
        List<DVD> list = new ArrayList();
        for (DVD d : userCollection){
                list.add(d);
        }
        return list;
    }
    

    @Override
    public DVD getById(int id) {
        for (DVD d : userCollection){
            if (d.getId()==(id)){
                return d;
            }
        }
        return null;
    }

    @Override
    public List<DVD> getByTitle(String title) {
        List<DVD> list = new ArrayList();
        for (DVD d : userCollection){
            if (d.getTitle().equals(title)){
                list.add(d);
            }
        }
        return list;
    }

    @Override
    public List<DVD> getByRating(String rating) {
        List<DVD> list = new ArrayList();
        for (DVD d : userCollection){
            if (d.getMpaaRating().equals(rating)){
                list.add(d);
            }
        }
        return list;
    }

    @Override
    public List<DVD> getByStudio(String studio) {
        List<DVD> list = new ArrayList();
        for (DVD d : userCollection){
            if (d.getStudio().equals(studio)){
                list.add(d);
            }
        }
        return list;
    }

    
    
}
