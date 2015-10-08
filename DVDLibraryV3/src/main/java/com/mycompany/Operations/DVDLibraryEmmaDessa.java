package com.mycompany.Operations;

import com.swcguild.dvdlibrary.dto.DVD;
import com.swcguild.dvdlibrary.dao.DvdLibraryDao;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DVDLibraryEmmaDessa implements DvdLibraryDao {

    ArrayList<DVD> shelf = new ArrayList<>();
    @Override
    public void add(DVD movie) {
        shelf.add(movie);
    }

    @Override
    public void remove(int i) {
        shelf.remove(i);
    }
    
    @Override
    public List<DVD> getByTitle(String title) {

        return shelf
                .stream()
                .filter(a -> a.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }
    
    @Override
    public List<DVD> getByStudio(String studio) {
        return shelf
                .stream()
                .filter(a -> a.getStudio().equalsIgnoreCase(studio))
                .collect(Collectors.toList());
                
    }
    
    @Override
    public List<DVD> getByRating(String rating) {
        return shelf
                .stream()
                .filter(a -> a.getMpaaRating().equalsIgnoreCase(rating))
                .collect(Collectors.toList());
                
    }

    @Override
    public ArrayList<DVD> listAll() {
        ArrayList<DVD> shelfCopy = new ArrayList<>();

        shelfCopy.addAll(shelf);
        return shelfCopy;
    }

    @Override
    public DVD getById(int id) {
        
        return shelf.get(id);
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
   
}

//   public List<Dvd> oldestMovie() {
//        int oldestYear =  shelf
//                .stream()                
//                .mapToInt(d -> (d.getReleaseDate().getYear()))
//                .min()
//                .getAsInt();
//        
//        return shelf
//                .stream()
//                .filter(a -> a.getReleaseDate().getYear() == oldestYear)
//                .collect(Collectors.toList());
//                
//    }
//    
//    public List<Dvd> newestMovie() {
//        int newestYears =  shelf
//                .stream()                
//                .mapToInt(a -> a.getReleaseDate().getYear())
//                .max()
//                .getAsInt();
//        
//        return shelf
//                .stream()
//                .filter(a -> a.getReleaseDate().getYear() == newestYears)
//                .collect(Collectors.toList());
//                
//    }
//
//    public int dvdCount() {
//        return shelf.size();
//    }
//
//    public int titleCount(String find) {
//        int count = 0;
//
//        count = (int) shelf
//                .stream()
//                .filter(a -> a.getTitle().equalsIgnoreCase(find))
//                .count();
//        //.map((temp) -> temp.getTitle()).filter((str) -> (find.equals(str))).map((_item) -> 1).reduce(count, Integer::sum);
//        return count;
//    }
//        
//    public ArrayList<Dvd> findByDate(int yearsBack) {
//        SimpleDateFormat calF = new SimpleDateFormat("yyyy");
//        int years = Integer.parseInt(calF.format(Calendar.getInstance().getTime()));
//        years -= yearsBack;
//
//        return (ArrayList<Dvd>) shelf
//                .stream()
//                .filter(a -> a.getReleaseDate().getYear() > yearsBack)
//                .collect(Collectors.toList());
//    }
//    
  

//    public double findAverageAge() {
//        SimpleDateFormat calF = new SimpleDateFormat("yyyy");
//        final int years = parseInt(calF.format(Calendar.getInstance().getTime()));
//        
//
//        return shelf
//                .stream()
//                .mapToDouble(a -> (years - parseInt(a.getReleaseDate())))
//                .average()
//                .getAsDouble();
//                
//        
//    }
    
//    public void populate(ArrayList<Dvd> inputShelf) {
//
//        shelf.addAll(inputShelf);
//    }
//