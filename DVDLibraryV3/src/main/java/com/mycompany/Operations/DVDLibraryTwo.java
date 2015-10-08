/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Operations;
import com.swcguild.dvdlibrary.dto.DVD;
import com.swcguild.dvdlibrary.dao.DvdLibraryDao;
import java.util.*;

/**
 *
 * @author apprentice
 */
public class DVDLibraryTwo implements DvdLibraryDao {

    ArrayList<DVD> dvdLibrary = new ArrayList<>();
    
    public DVDLibraryTwo(){
        dvdLibrary = new ArrayList<>();
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

    public void add(DVD a) {
        dvdLibrary.add(a);
    }

//    public ArrayList<Dvd> copyList() {
//
//        return dvdLibrary;
//    }

    public void remove(int id) {
        DVD r = getById(id);
        dvdLibrary.remove(r);

    }

    public List<DVD> listAll() {
        ArrayList tempArrL = (ArrayList) dvdLibrary.clone();
        return tempArrL;
    }

    public DVD getById(int id) {
        DVD temp = null;
        for (int i = 0; i < dvdLibrary.size(); i++) {
            if (dvdLibrary.get(i).getId() == id) {
                temp = dvdLibrary.get(i);
            }
        }
        return temp;
    }

    public List<DVD> getByTitle(String title) {
        ArrayList<DVD> temp = new ArrayList<>();
        for (int i = 0; i < dvdLibrary.size(); i++) {
            if (dvdLibrary.get(i).getTitle().equalsIgnoreCase(title)) {
                temp.add(dvdLibrary.get(i));
            }
        }
        return temp;
    }

    public List<DVD> getByRating(String rating) {
        ArrayList<DVD> temp = new ArrayList<>();
        for (int i = 0; i < dvdLibrary.size(); i++) {
            if (dvdLibrary.get(i).getMpaaRating().equalsIgnoreCase(rating)) {
                temp.add(dvdLibrary.get(i));
            }
        }
        return temp;
    }

    public List<DVD> getByStudio(String studio) {
        ArrayList<DVD> temp = new ArrayList<>();
        for (int i = 0; i < dvdLibrary.size(); i++) {
            if (dvdLibrary.get(i).getStudio().equalsIgnoreCase(studio)) {
                temp.add(dvdLibrary.get(i));
            }
        }
        return temp;
    }

//    public DVD findDVD(String title) {
//        Dvd reqDVD = null;
//
//        for (int i = 0; i < dvdLibrary.size(); i++) {
//            Dvd temp = dvdLibrary.get(i);
//
//            if (temp.getTitle().equals(title)) {
//                reqDVD = temp;
//            }
//        }
//        return reqDVD;
//
//    }
//
//    public ArrayList allDVD() {
//        ArrayList tempArrL = (ArrayList) dvdLibrary.clone();
//        return tempArrL;
//    }
//
//    public void addLibraryViaReader(ArrayList<Dvd> d) {
//        dvdLibrary.addAll(d);
//    }
//
//    public int howMany(String title) {
//        int num = 0;
//        for (int i = 0; i < dvdLibrary.size(); i++) {
//            Dvd temp = dvdLibrary.get(i);
//
//            if (temp.getTitle().equals(title)) {
//                num += 1;
//
//            }
//
//        }
//        return num;
//
//    }
//    
//    public int size() {
//        return dvdLibrary.size();
//    }
}
