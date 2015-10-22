


package com.mycompany.dvdlibraryv4.dao;

import com.mycompany.dvdlibraryv4.model.DVD;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class DvdLibraryDaoImpl implements DvdLibraryDao {

    private Map<Integer, DVD> dvdMap = new HashMap<>();
// used to assign ids to DVDs - simulates the auto increment
// primary key for DVDs in a database
    private static int dvdIdCounter = 0;
    
    @Override
    public DVD addDVD(DVD dvd) {
        dvd.setId(dvdIdCounter);
        dvdIdCounter++;
        dvdMap.put(dvd.getId(), dvd);
        return dvd;
    }

    @Override
    public void removeDVD(int DVDId) {
        dvdMap.remove(DVDId);
    }

    @Override
    public void updateDVD(DVD dvd) {
        dvdMap.put(dvd.getId(), dvd);
    }

    @Override
    public List<DVD> getAllDVDs() {
        Collection<DVD> d = dvdMap.values();
        return new ArrayList(d);
    }

    @Override
    public DVD getDVDById(int DVDId) {
        return dvdMap.get(DVDId);
    }

    @Override
    public List<DVD> searchDVDs(Map<SearchTerm, String> criteria) {
        String titleCriteria = criteria.get(SearchTerm.TITLE);
        String releasedateCriteria = criteria.get(SearchTerm.RELEASE_DATE);
        String mpaaratingCriteria = criteria.get(SearchTerm.MPAA_RATING);
        String studioCriteria = criteria.get(SearchTerm.STUDIO);
        String directorCriteria = criteria.get(SearchTerm.DIRECTOR);
        String noteCriteria = criteria.get(SearchTerm.NOTE);
        
        Predicate<DVD> titleMatches;
        Predicate<DVD> releasedateMatches;
        Predicate<DVD> mpaaratingMatches;
        Predicate<DVD> studioMatches;
        Predicate<DVD> directorMatches;
        Predicate<DVD> noteMatches;
        
        Predicate<DVD> truePredicate = (c) -> {return true;};
        
        titleMatches = (titleCriteria == null || titleCriteria.isEmpty())
                ? truePredicate : (c) -> c.getTitle().equals(titleCriteria);
        releasedateMatches = (releasedateCriteria == null || releasedateCriteria.isEmpty())
                ? truePredicate : (c) -> c.getReleaseDate().equals(releasedateCriteria);
        mpaaratingMatches = (mpaaratingCriteria == null || mpaaratingCriteria.isEmpty())
                ? truePredicate : (c) -> c.getMpaaRating().equals(mpaaratingCriteria);
        studioMatches   = (studioCriteria == null || studioCriteria.isEmpty())
                ? truePredicate : (c) -> c.getStudio().equals(studioCriteria);
        directorMatches = (directorCriteria == null || directorCriteria.isEmpty())
                ? truePredicate : (c) -> c.getDirector().equals(directorCriteria);
        noteMatches     = (noteCriteria == null || noteCriteria.isEmpty())
                ? truePredicate : (c) -> c.getNote().equals(noteCriteria);   
        
        return dvdMap.values().stream()
                .filter(titleMatches
                        .and(releasedateMatches)
                        .and(mpaaratingMatches)
                        .and(studioMatches)
                        .and(directorMatches)
                        .and(noteMatches))
                .collect(Collectors.toList());
    }

}
