/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibraryv4.dao;

import com.mycompany.dvdlibraryv4.model.DVD;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface DvdLibraryDao {
    // add the given DVD to the data store

    public DVD addDVD(DVD DVD);
// remove the DVD with the given id from the data store

    public void removeDVD(int DVDId);
// update the given DVD in the data store

    public void updateDVD(DVD DVD);
// retrieve all DVDs from the data store

    public List<DVD> getAllDVDs();
// retrieve the DVD with the given id from the data store

    public DVD getDVDById(int DVDId);
// search for DVDs by the given search criteria values

    public List<DVD> searchDVDs(Map<SearchTerm, String> criteria);

}
